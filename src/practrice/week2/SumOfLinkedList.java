package src.practrice.week2;

public class SumOfLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();

        list1.append(6);
        list1.append(7);
        list1.append(8);

        list2.append(3);
        list2.append(5);
        list2.append(4);

        System.out.println(solve(list1, list2));

    }

    public static int solve(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        String list1Str = list1.printAll2();
        String list2Str = list2.printAll2();

        return Integer.parseInt(list1Str) + Integer.parseInt(list2Str);
    }
}
