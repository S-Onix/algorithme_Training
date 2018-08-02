package Sort;

public class Sort {
    public static void main(String[] args) {
        int [] arrayt = {9,7,7,5,4,8,9,5,43,2,4,2,1};
        InsertionSort(arrayt,6);
        BubbleSort(list,6);
        SelectionSort(list, 6);

    }

    private static int [] list = { 3,5,7,9,1,4};

    public static void SelectionSort(int array[] , int n ){
        int indexMin, temp;

        for (int i = 0; i < n-1; i++) {
            indexMin = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
            }
            temp = array[indexMin];
            array[indexMin] = array[i];
            array[i] = temp;
        }
    }

    public static void BubbleSort(int array[], int n){
        int temp;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-i-1; j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static int[] InsertionSort(int array[], int n){
        int temp;
        int j = 0;
        for(int i = 1; i < n; i++){
            temp = array[i];
            for(j = i-1 ; j>=0 && temp<array[j]; j--){
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }

        return array;

    }
}