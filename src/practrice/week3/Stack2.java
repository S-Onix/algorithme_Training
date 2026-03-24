package src.practrice.week3;

public class Stack2 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    int size;

    public void push(int value) {
        if(head == null) {
            head = new Node(value);
        }else {
            Node newNode = new Node(value);

            newNode.next = head;
            head = newNode;
        }
        this.size++;
    }

    public Node pop() {
        if(head == null) {
            return null;
        }else {
            Node deleteNode = head;
            head = head.next;
            this.size--;
            return deleteNode;
        }
    }

    public Node peek() {
        return head != null ? head : null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
