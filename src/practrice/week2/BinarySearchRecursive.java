package src.practrice.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchRecursive {

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

        System.out.println(binarySearchRecursive(list, 9, 0, list.size() - 1));

    }

    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {

        if(arr == null || arr.length == 0) return -1;
        int mid = (left + right)/2;
        if(arr[mid] == target) {
            return mid;
        }else if(arr[mid] < target) {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }else {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }
    }

    public static int binarySearchRecursive(List<Integer> arr, int target, int left, int right) {

        if(arr == null || arr.size() == 0) return -1;
        if(left == right) {
            if( arr.get(left) == target) {
                return arr.get(left);
            }else {
                return -1;
            }
        }
        int mid = (left + right)/2;
        if(arr.get(mid) == target) {
            return arr.get(mid);
        }else if(arr.get(mid) < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
}
