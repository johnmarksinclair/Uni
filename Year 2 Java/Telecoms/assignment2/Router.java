package assignment2;

import java.io.IOException;
import java.net.*;
import java.util.regex.Pattern;

public class Router extends Node {
	
	Terminal terminal;
	InetSocketAddress controlAdd;
	InetSocketAddress myAdd;
	InetSocketAddress nextAdd;
	RouterFlowTable myTable;
	byte[] content;

	Router(Terminal terminal, String dstHost, int dstPort, int srcPort) {
		try {
			this.terminal = terminal;
			this.controlAdd = new InetSocketAddress(dstHost, dstPort);
			this.myAdd = new InetSocketAddress(dstHost, srcPort);
			//terminal.println("My Socket Address: " + this.myAdd);
			socket = new DatagramSocket(srcPort);
			listener.go();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void onReceipt(DatagramPacket packet) {
		try {
			byte[] data = packet.getData();
			switch (data[TYPE_POS]) {
			case TYPE_CONNECT_ACK:
				terminal.println("Connected to Controller");
				break;
			case TYPE_ACK:
				terminal.println("Successfully forwarded to Router " + (packet.getPort() - FIRST_ROUTER_PORT + 1));
				break;
			case TYPE_USER_ACK:
				terminal.println("Successfully forwarded to User " + (packet.getPort() - USER1_PORT + 1));
				break;
			case USER1:
			case USER2:
				content = getByteContent(packet);
				terminal.println("Received packet from User " + (packet.getPort() - USER1_PORT + 1));
				socket.send(createPacket(packet, TYPE_ACK, null, null)); // send acknowledgement
				terminal.println("Requesting flow table...");
				socket.send(createPacket(packet, FEA_REQ, null, null)); // send a feature request
				break;
			case ROUTER:
				content = getByteContent(packet);
				terminal.println("Received packet from Router " + (packet.getPort() - FIRST_ROUTER_PORT + 1));
				socket.send(createPacket(packet, TYPE_ACK, null, null));
				terminal.println("Requesting flow table...");
				socket.send(createPacket(packet, FEA_REQ, null, null)); // send a feature request
				break;
			case CONTROLLER:
				terminal.println("Received routing info");
				myTable = getTable(packet);
				updateInfo();
				forwardPackage(packet);
				break;
			default:
				terminal.println("Message received: " + getStringContent(packet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//TODO
	public void updateInfo() {
		this.nextAdd = new InetSocketAddress(DEFAULT_DST_NODE, myTable.hops.get(0).getOut());
	}
	
	public void forwardPackage(DatagramPacket packet) throws IOException {
		terminal.println("Forwarding...");
		socket.send(createPacket(packet, ROUTER, content, nextAdd));
	}
	
	public RouterFlowTable getTable(DatagramPacket packet) {
		RouterFlowTable table = new RouterFlowTable();
		String content = getStringContent(packet);
		//System.out.println(content);
		String[] partitioned = content.split(Pattern.quote("."));
		int dest, in, out;
		int i = 0;
		while (i < partitioned.length) {
			dest = Integer.valueOf(partitioned[i]);
			in = Integer.valueOf(partitioned[i+1]);
			out = Integer.valueOf(partitioned[i+2]);
			table.addHop(dest, in, out);
			i += 3;
		}
		return table;
	}
	
	public synchronized void contactController() throws Exception {
		byte[] data = null;
		String input = "Connect me";
		byte[] message = input.getBytes();
		DatagramPacket packet = null;
		data = new byte[HEADER_LENGTH + message.length];
		data[TYPE_POS] = ROUTER_CON;
		data[LENGTH_POS] = (byte) message.length;
		System.arraycopy(message, 0, data, HEADER_LENGTH, message.length);
		terminal.println("Connecting to Controller...");
		packet = new DatagramPacket(data, data.length);
		packet.setSocketAddress(controlAdd);
		socket.send(packet);
	}

	public static void main(String[] args) {
		try {
			for (int i = 0; i < NO_OF_ROUTERS; i++) {
				Terminal terminal = new Terminal("Router " + (i + 1));
				Router router = new Router(terminal, DEFAULT_DST_NODE, CONTROLLER_PORT, FIRST_ROUTER_PORT + i);
				router.contactController();
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}
