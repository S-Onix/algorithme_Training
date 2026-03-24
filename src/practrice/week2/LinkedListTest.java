package src.practrice.week2;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);

        list.delete(4);
        list.printAll();
        list.insert(4,6);
        list.printAll();
        Node<Integer> node = list.findNode(7);
        System.out.println(node.getValue());


    }
}
