#ifndef Q2.H
#define Q2.H

struct node {
    struct node * next;
    struct node * prev;
    int val;
};

struct deque {
    struct node * head;
    struct node * tail;
};

#endif