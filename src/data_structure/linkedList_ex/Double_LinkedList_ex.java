package data_structure.linkedList_ex;

public class Double_LinkedList_ex<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> nextNode;
        Node<T> prevNode;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.tail;
        } else {
            Node<T> node = this.head;
            while (node.nextNode != null) {
                node = node.nextNode;
            }
            node.nextNode = new Node<T>(data);
            this.tail = node.nextNode;
            node.nextNode.prevNode = node;
        }
    }

    public void printAll() {
        if (this.head == null) {
            return;
        } else {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.nextNode != null) {
                node = node.nextNode;
                System.out.println(node.data);
            }
        }
    }

    // head에서 특정 노드 찾아가기
    public T findNodeFromHead(T data) {
        if(this.head == null) {
            return null;
        }else {
            Node<T> node = this.head;
            while(node.nextNode!= null) {
                if(node.data == data){
                    return node.data;
                }
                node = node.nextNode;
            }
            return null;
        }
    }

    // tail에서 특정 노드 찾아가기
    public T findNodeFromTail(T data) {
        if(this.head == null) {
            return null;
        }else {
            Node<T> node = this.tail;
            while(node != null) {
                if(node.data == data) {
                    return node.data;
                }
                node = node.prevNode;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Double_LinkedList_ex<Integer> test = new Double_LinkedList_ex<>();
        test.addNode(1);
        test.addNode(2);
        test.addNode(3);
        test.addNode(4);
        test.addNode(5);

        test.printAll();
        System.out.println(test.findNodeFromHead(3));
        System.out.println(test.findNodeFromHead(6));


    }

}
