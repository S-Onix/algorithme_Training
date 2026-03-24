package src.practrice.week2;

public class Homework_linkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);

        System.out.println(solve(list, 0));
    }

    public static Integer solve(LinkedList<Integer> list, int target_last) {
        if(list.getSize() - target_last >= 0 && list.getSize() - target_last < list.getSize()) {
            Node<Integer> node = list.findNode(list.getSize() - target_last);
            return node.getValue();
        }

        return -1;
    }
}
