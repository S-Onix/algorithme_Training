package data_structure.linkedList_ex;

public class LinkedList_ex <T>{
    public Node<T> head = null;

    class Node <T>{
        public T data;
        public Node<T> nextNode = null;

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<T>(data);
        }
        Node<T> node = this.head;
        while(node.nextNode != null) {
            node = node.nextNode;
        }
        node.nextNode = new Node(data);
    }

    public void printAll() {
        if(head !=null) {
            Node<T> node = this.head;
            while(node.nextNode != null) {
                node = node.nextNode;
                System.out.println(node.data);
            }
        }
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }
        Node node = head;
        Node nextNode = head.nextNode;
        while(head.nextNode != null) {
        }
    }

    public static void main(String[] args) {
        LinkedList_ex<Integer> linkedList = new LinkedList_ex<>();

        linkedList.add(2);

        linkedList.printAll();
    }
}
