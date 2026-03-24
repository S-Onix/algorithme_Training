package src.practrice.week3;

public class Queue {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        this.tail.next = newNode;
        this.tail = newNode;
    }

    public Node dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        Node deleteHead = this.head;
        this.head = this.head.next;

        return deleteHead;
    }

    public Object peek() {
        if (isEmpty()) {
            return "Queue is empty";
        }

        return this.head.data;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}

