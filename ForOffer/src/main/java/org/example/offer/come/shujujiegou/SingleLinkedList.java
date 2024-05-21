package org.example.offer.come.shujujiegou;

public class SingleLinkedList {
    private int length;
    private Node head;

    public SingleLinkedList() {
        length = 0;
        head = null;
    }
    private class Node {
        private Object data;
        private Node next;
        public Node(Object data) {
            this.data = data;
        }
    }

    public Object addHead(Object object) {
        Node newHead = new Node(object); //定义新节点
        if (length == 0) {
            head = newHead;
        } else { //设置当前节点为头部节点，并将当前节点的下一个节点指向原来的节点
            newHead.next = head;
            head = newHead;
        }
        length ++;
        return object;
    }

    public boolean delete(Object value) {
        if (length == 0) {
            return false;
        }
        Node current = head;
        Node previous = head;
        while (current.data != value) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = current.next;
            length--;
        } else {
            previous.next = current.next;
            length--;
        }
        return true;
    }

    public Node find(Object object) {
        Node current = head;
        while (current.next != null) {
            if (object.equals(current.data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


}
