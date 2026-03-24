package src.practrice.week2;

public class LinkedList<T> {

    Node<T> head;
    int size = 0;
    public LinkedList() {
        head = null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void insert(T value, int index) {
        Node<T> current = head;
        if (current == null) head = new Node<>(value);
        else {
            int currentIndex = 0;
            Node<T> newNode = new Node<>(value);
            if (index == 0) {
                newNode.setNextNode(head);
                head = newNode;
                this.setSize(this.getSize() + 1);
            } else {
                Node<T> prev;
                while(current.getNextNode() != null) {
                    prev = current;
                    current = current.getNextNode();
                    currentIndex++;
                    if(currentIndex == index) {
                        prev.setNextNode(newNode);
                        newNode.setNextNode(current);
                        this.setSize(this.getSize() + 1);
                        return;
                    }
                }
                current.setNextNode(newNode);
                this.setSize(this.getSize() + 1);
            }
        }
    }

    public void insert2(T value, int index) {
        Node<T> prev = this.findNode(index-1);
        Node<T> after = prev.getNextNode();
        Node<T> newNode = new Node<>(value);

        if(after != null) { // prev 가 끝이 아닌경우
            prev.setNextNode(newNode);
            newNode.setNextNode(after);
        }else { // prev 가 끝인 경우
            prev.setNextNode(newNode);
        }
        this.setSize(this.getSize() + 1);


    }

    public void printAll(){
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;

        if(current == null) return;
        while(current.getNextNode() != null) {
            sb.append("[");
            sb.append(current.getValue());
            sb.append("]");
            current = current.getNextNode();
            sb.append("->");
        }

        sb.append("[");
        sb.append(current.getValue());
        sb.append("]");

        System.out.println(sb.toString());
    }

    public String printAll2(){
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;

        if(current == null) return "";
        while(current.getNextNode() != null) {
            sb.append(current.getValue());
            current = current.getNextNode();
        }

        sb.append(current.getValue());

        return sb.toString();
    }


    public void append(T value) {
        Node<T> current = head;
        if(current == null) {
            head = new Node<T>(value);
            this.setSize(this.getSize() + 1);
            return;
        }
        else {
            while(current.getNextNode() != null) {
                current = current.getNextNode();
            }
        }
        current.setNextNode(new Node<T>(value));
        this.setSize(this.getSize() + 1);
    }

    public void firstDelete() {
        if(head == null) return;
        head = head.getNextNode();
        this.setSize(this.getSize() - 1);
    }

    public void lastDelete() {
        Node<T> current = head;
        Node<T> before = head;

        if(current == null) return;

        while(current.getNextNode() != null) {
            before = current;
            current = current.getNextNode();
        }

        before.setNextNode(null);
        this.setSize(this.getSize() - 1);
    }

    public void delete(T value) {
        Node<T> current = head;
        Node<T> before = head;
        if(current == null) return;

        while(current.getNextNode() != null) {
            before = current;
            current = current.getNextNode();
            if(current.getValue().equals(value)) {
                before.setNextNode(current.getNextNode());
            }
        }
        this.setSize(this.getSize() - 1);
    }

    public void delete(int index) {
        int currentIndex = 0;
        Node<T> current = head;
        Node<T> prev = head;

        if(getSize() == 0) return;

        if(index == 0) {
            firstDelete();
            return;
        }

        if(index <= getSize()-1) {
            if (current == null) return;
            while (index != currentIndex) {
                prev = current;
                current = current.getNextNode();
                currentIndex++;

                if (currentIndex == index) {
                    prev.setNextNode(current.getNextNode());
                    this.setSize(this.getSize() - 1);
                    break;
                }
            }
        }
    }

    public Node<T> findNode(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        if(getSize() > 0) {
            if(current == null) return null;

            if(index > this.getSize()) {
                return findNode(this.getSize()-1);
            }

            if(index == 0) {
                return head;
            }

            while(currentIndex != index) {
                current = current.getNextNode();
                currentIndex++;
            }
        }

        return current;
    }

    public Node<T> findNode(T value) {
        Node<T> current = head;
        if(current == null) return null;
        while(current != null) {
            if(current.getValue() == value) {
                return current;
            }else current = current.getNextNode();
        }
        System.out.println("Not Found Node");
        return null;
    }
}
