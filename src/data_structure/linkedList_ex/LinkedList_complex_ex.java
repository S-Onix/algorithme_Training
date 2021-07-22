package data_structure.linkedList_ex;

public class LinkedList_complex_ex<T> {
    Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> nextNode;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node(data);
        }
        Node node = this.head;
        while (node.nextNode != null) {
            node = node.nextNode;
        }
        node.nextNode = new Node(data);
    }

    public void addNodeInside(T data, T isData) {
        Node<T> searchNode = this.searchNode(isData);

        if (searchNode == null) {
            this.addNode(data);
        } else {
            /*
             * 내가 짠 방법 1
             * */
            //Node<T> nextNode = searchNode.nextNode;
            //Node<T> newNode = new Node(data);

            //searchNode.nextNode = newNode;
            //newNode.nextNode = nextNode;

            Node<T> nextNode = searchNode.nextNode;
            searchNode.nextNode = new Node(data);
            searchNode.nextNode.nextNode = nextNode;

        }
    }

    public boolean delNode(T isData) {
        if (this.head == null) {
            return false;
        } else {
            Node node = this.head;

            //삭제해야할 노드가 첫번째인 경우
            if (node.data == isData) {
                this.head = this.head.nextNode;
                return true;
            }
            while (node.nextNode != null) {
                if (node.nextNode.data == isData) {
                    node.nextNode = node.nextNode.nextNode;
                    return true;
                }
                node = node.nextNode;
            }
            return false;
        }
    }

    public Node<T> searchNode(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.nextNode;
                }
            }
            return null;
        }
    }

    public void printAllNode() {
        if (this.head == null) {
            return;
        } else {
            Node<T> node = this.head;
            while (node.nextNode != null) {
                node = node.nextNode;
                System.out.println(node.data);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList_complex_ex linkedListC = new LinkedList_complex_ex();
        linkedListC.addNode(1);
        linkedListC.addNode(2);
        linkedListC.addNode(3);
        linkedListC.addNode(4);

        linkedListC.printAllNode();

        System.out.println("=============================");

        linkedListC.addNodeInside(5, 2);
        linkedListC.printAllNode();
        linkedListC.delNode(1);

        System.out.println("=============================");
        linkedListC.printAllNode();
    }
}


