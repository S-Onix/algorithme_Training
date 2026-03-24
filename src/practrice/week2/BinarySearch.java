package src.practrice.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    /**
     * 기본개념 :: 업다운
     * 전제조건 :: 숫자는 정렬되어있어야한다.
     * */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(6);
        list.add(2);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(7);
        list.add(1998);
        list.add(15);
        list.add(17);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        boolean isExist = binarySearch(list,15);
        System.out.println(isExist);
    }

    public static boolean binarySearch(List<Integer> sortedList,int num) {
        int startIndex = 0;
        int findCount = 0;
        int endIndex = sortedList.size() - 1;
        int searchIndex = ( startIndex + endIndex ) / 2;

        while(startIndex <= endIndex) {
            findCount++;
            Integer findNum = sortedList.get(searchIndex);
            if(findNum.equals(num)) {
                System.out.println("총 탐색횟수 :: " + findCount);
                return true;
            }else if(findNum < num){
                startIndex = searchIndex + 1;
            }else {
                endIndex = searchIndex - 1;
            }

            searchIndex = (startIndex + endIndex) / 2;
        }
        System.out.println("총 탐색횟수 :: " + findCount);
        return false;
    }
}
