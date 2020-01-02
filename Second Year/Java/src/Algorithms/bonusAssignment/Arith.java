package Algorithms.bonusAssignment;

//-------------------------------------------------------------------------
/**
 * Utility class containing validation/evaluation/conversion operations for
 * prefix and postfix arithmetic expressions.
 *
 * @author John Sinclair
 * @version 1/12/15 13:03:48
 */

public class Arith {

//~ Validation methods ..........................................................

    /**
     * Validation method for prefix notation.
     *
     * @param prefixLiterals : an array containing the string literals hopefully in
     *                       prefix order. The method assumes that each of these
     *                       literals can be one of: - "+", "-", "*", or "/" - or a
     *                       valid string representation of an integer.
     *
     * @return true if the parameter is indeed in prefix notation, and false
     *         otherwise.
     **/
    public static boolean validatePrefixOrder(String prefixLiterals[]) {
        // TODO
        return true;
    }

    /**
     * Validation method for postfix notation.
     *
     * @param postfixLiterals : an array containing the string literals hopefully in
     *                        postfix order. The method assumes that each of these
     *                        literals can be one of: - "+", "-", "*", or "/" - or a
     *                        valid string representation of an integer.
     *
     * @return true if the parameter is indeed in postfix notation, and false
     *         otherwise.
     **/
    public static boolean validatePostfixOrder(String postfixLiterals[]) {
        // TODO
        return true;
    }

//~ Evaluation  methods ..........................................................

    /**
     * Evaluation method for prefix notation.
     *
     * @param prefixLiterals : an array containing the string literals in prefix
     *                       order. The method assumes that each of these literals
     *                       can be one of: - "+", "-", "*", or "/" - or a valid
     *                       string representation of an integer.
     *
     * @return the integer result of evaluating the expression
     **/
    public static int evaluatePrefixOrder(String prefixLiterals[]) {
        // TODO
        return -1;
    }

    /**
     * Evaluation method for postfix notation.
     *
     * @param postfixLiterals : an array containing the string literals in postfix
     *                        order. The method assumes that each of these literals
     *                        can be one of: - "+", "-", "*", or "/" - or a valid
     *                        string representation of an integer.
     *
     * @return the integer result of evaluating the expression
     **/
    public static int evaluatePostfixOrder(String postfixLiterals[]) {
        // TODO
        return -1;
    }

//~ Conversion  methods ..........................................................

    /**
     * Converts prefix to postfix.
     *
     * @param prefixLiterals : an array containing the string literals in prefix
     *                       order. The method assumes that each of these literals
     *                       can be one of: - "+", "-", "*", or "/" - or a valid
     *                       string representation of an integer.
     *
     * @return the expression in postfix order.
     **/
    public static String[] convertPrefixToPostfix(String prefixLiterals[]) {
        // TODO
        return null;
    }

    /**
     * Converts postfix to prefix.
     *
     * @param prefixLiterals : an array containing the string literals in postfix
     *                       order. The method assumes that each of these literals
     *                       can be one of: - "+", "-", "*", or "/" - or a valid
     *                       string representation of an integer.
     *
     * @return the expression in prefix order.
     **/
    public static String[] convertPostfixToPrefix(String postfixLiterals[]) {
        // TODO
        return null;
    }

    /**
     * Converts prefix to infix.
     *
     * @param infixLiterals : an array containing the string literals in prefix
     *                      order. The method assumes that each of these literals
     *                      can be one of: - "+", "-", "*", or "/" - or a valid
     *                      string representation of an integer.
     *
     * @return the expression in infix order.
     **/
    public static String[] convertPrefixToInfix(String prefixLiterals[]) {
        // TODO
        return null;
    }

    /**
     * Converts postfix to infix.
     *
     * @param infixLiterals : an array containing the string literals in postfix
     *                      order. The method assumes that each of these literals
     *                      can be one of: - "+", "-", "*", or "/" - or a valid
     *                      string representation of an integer.
     *
     * @return the expression in infix order.
     **/
    public static String[] convertPostfixToInfix(String postfixLiterals[]) {
        String[] infixExp = new String[0];
        return infixExp;
    }

    public static void main( String[] args) {
        System.out.println("yo");
    }
}