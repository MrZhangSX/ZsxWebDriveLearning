package org.example.offer.come.shujujiegou;

//双向链表
public class TwoWayLinkedList {
    private Node head;
    private Node tail;
    private int length;
    private class Node {
        private Object data;
        private Node next;
        private Node prev;
        public Node(Object data) {
            this.data = data;
        }
    }

    public TwoWayLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public void addHead(Object value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
            head = newNode;
            length ++;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            length++;
        }
    }

    public void addTail(Object value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
            head = newNode;
            length ++;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            length++;
        }
    }

    public Node deleteHead() {
        Node temp = head;
        if (length != 0) {
            head = head.next;
            head.prev = null;
            length --;
        }
        return temp;
    }

    public Node deleteTail() {
        Node temp = tail;
        if (length != 0) {
            tail = tail.prev;
            tail.next = null;
            length --;
        }
        return temp;
    }
}
