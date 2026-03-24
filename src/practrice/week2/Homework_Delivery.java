package src.practrice.week2;

import java.util.Arrays;
import java.util.HashSet;

public class Homework_Delivery {
    public static void main(String[] args) {
        boolean result1 = true;
        boolean result2 = true;
        LinkedList<String> menus = new LinkedList<>();
        HashSet<String> menuSet = new HashSet<>();
        String [] menusString = {"떡볶이", "만두", "오뎅", "사이다", "콜라"};
        // "떡볶이", "만두", "오뎅", "사이다", "콜라"
        menus.append("떡볶이");
        menus.append("만두");
        menus.append("오뎅");
        menus.append("사이다");
        menus.append("콜라");

        menuSet.add("떡볶이");
        menuSet.add("만두");
        menuSet.add("오뎅");
        menuSet.add("사이다");
        menuSet.add("콜라");


        String [] orders = {"오뎅", "콜라", "만두"};

        for(int i = 0 ; i < orders.length; i++) {
            if(!Arrays.stream(menusString).anyMatch(orders[i]::equals)) {
                result1 = false;
            }
        }

        for(int i = 0 ; i < orders.length; i++) {
            if(!menuSet.contains(orders[i])) {
                result2 = false;
            }
        }

        System.out.println(result1);
        System.out.println(result2);
    }


}
