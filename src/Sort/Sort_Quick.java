package Sort;

public class Sort_Quick {
    private static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }
    private static void quickSort(int[] array, int start, int end){
        //오른쪽 파티션의 첫번째 값
        int rightPartFirstValue = partition(array, start, end);
        //오른쪽방과 왼쪽방의 개수가 이상 차이가 나야 재귀함수 호출
        if(start < rightPartFirstValue-1){
            quickSort(array,start, rightPartFirstValue-1);
        }
        if(rightPartFirstValue < end){
            quickSort(array, rightPartFirstValue, end);
        }
    }

    private static int partition(int [] array, int start, int end){
        int pivot = array[(start+end)/2];
        int temp = 0;
        while(start <= end){
            while(array[start] < pivot) start++;
            while(array[end] > pivot) end--;
            if(start <= end) {
                swap(array,start,end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int [] array, int start, int end){
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    private static void printArray(int [] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String [] args){
        int [] array = {1,8,4,5,2,5,8,74,1,56,1,32,15,189,15};
        printArray(array);
        quickSort(array);
        printArray(array);
    }

}
