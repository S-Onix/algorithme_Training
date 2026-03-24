package src.practrice.week3;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {1,5,2,1,3,4,2,5,7};

        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length -1; i++) {
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
