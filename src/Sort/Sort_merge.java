package Sort;

public class Sort_merge {

    public static void main(String [] args){
        int array[] = {1,2,5,4,8,21,6,5,185,12,81,0};
        printArray(array);
        mergeSort(array);
        printArray(array);
    }

    private static void printArray(int array[]){
        for(int data : array){
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    private static void mergeSort(int [] array){
        int [] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length-1);
    }

    public static void mergeSort(int [] array, int[] temp, int start, int end){
        if(start<end) {
            int mid = (start+end)/2;
            mergeSort(array, temp, start, mid);
            mergeSort(array, temp, mid+1, end);
            merge(array, temp, start, mid, end);
        }
    }

    public static void merge(int [] array, int [] temp, int start, int mid, int end){
        for(int a = start; a<=end;a++){
            temp[a] = array[a];
        }
        int i = start;
        int j = mid+1;
        int k = start;

        while(i<=mid && j<=end){
            if(temp[i] <= temp[j]) {
                array[k] = temp[i];
                i++;
            }
            else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        //앞 쪽의 데이터가 남아았을 때
        for(int front = 0; front <= mid-i ; front++){
            array[k+front] = temp[i+front];
        }
    }
}
