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

    // 임의 노드 앞에 노드를 추가하는 메소드
    public void addNodeFromSpecifySite(T beforeData, T insertData) {
        // 앞과 뒤에서 동시에 돌아아야 빠르게 마무리됨
        if(this.head == null) {
            return;
        }else if (findNodeFromHead(beforeData) == null){
            return;
        }else if (this.head.data == beforeData){
            Node<T> newHead = new Node(insertData);
            newHead.nextNode = this.head;
            this.head = newHead;
        }else {
            Node<T> foreNode = this.head;
            Node<T> backNode = this.tail;

            while(foreNode != backNode) {
                if(foreNode.data == beforeData) {
                    Node<T> nodePrev = foreNode.prevNode;
                    nodePrev.nextNode = new Node(insertData);
                    nodePrev.nextNode.nextNode = foreNode;

                    nodePrev.nextNode.prevNode = nodePrev;
                    foreNode.prevNode = nodePrev.nextNode;
                    return;
                }else {
                    foreNode = foreNode.nextNode;
                }

                if(backNode.data == beforeData) {
                    Node<T> insertNode = new Node(insertData);
                    backNode.prevNode.nextNode = insertNode;
                    insertNode.prevNode = backNode.prevNode;
                    insertNode.nextNode = backNode;
                    backNode.prevNode = insertNode;
                }else {
                    backNode = backNode.prevNode;
                }
            }
            if (foreNode.data == beforeData) {
                Node<T> insertNode = new Node(insertData);
                foreNode.prevNode.nextNode = insertNode;
                insertNode.prevNode = foreNode.prevNode;
                insertNode.nextNode = foreNode;
                return;
            }

        }
    }
    public boolean addNodebeforeSite(T isData, T insertData){
        if(this.head == null) {
            Node<T> node = new Node<>(insertData);
            this.head = node;
            return true;
        }else if (this.head.data == isData) {
            Node<T> node = new Node<>(insertData);
            node.nextNode = this.head;
            this.head = node;
            return true;
        }else {
            Node<T> node = this.head;
            while(node != null) {
                if(node.data == isData) {
                    Node insertNode = new Node(insertData);

                    node.prevNode.nextNode = insertNode;
                    insertNode.prevNode = node.prevNode;

                    insertNode.nextNode = node;
                    node.prevNode = insertNode;
                    return true;
                }
                node = node.nextNode;
            }
            return false;
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

        test.addNodeFromSpecifySite(3, 45);
        test.addNodeFromSpecifySite(1, 22);
        test.addNodebeforeSite(5, 21);
        test.printAll();

    }

}
