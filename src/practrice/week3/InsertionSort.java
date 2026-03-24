package src.practrice.week3;

public class InsertionSort {
    public static void main(String[] args) {
        int [] arr = {1,5,2,1,3,4,2,5,7};
        insertionSort(arr);
    }


    public static void insertionSort(int [] arr) {
        /**
         * 첫번째와 두번째 비교
         * 두번째와 세번째비교
         *         두번째가 더 크면 switch 하고 두번째와 첫번째 비교
         *         두번째가 더 작으면 그대로
         * 세번쨰와 네번째 비교
         *         네번째와 세번째 중 세번째가 더 크면 switch 하고 세번째와 두번째 비교
         *         세번쨰와 두번째 중 두번째가 더 크면 switch 하고 두번째와 첫번째 비교
         * */

        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i+1; j > 0 && arr[j-1] > arr[j]; j--) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
