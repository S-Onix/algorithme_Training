package doitalgorithm.chpater02;

public class P61 {
    static int [] swapIndexQ02(int [] array, int index1, int index2){
        System.out.println("array[" + index1 + "] 와 array[" + index2 + "]를 교환합니다.");
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

        return array;
    }

    static void printArray(int [] array){
        for(int i = 0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static int [] convertArray(int array[]){
        int temp = 0;
        for(int i = 0; i < array.length/2 ; i++){
            temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }

        return array;
    }

    static void startQ2(){
        int [] array = {5,10,73,2,-5,42};

        convertArray(array);
        printArray(array);

        swapIndexQ02(array,0,5);
        printArray(array);

        swapIndexQ02(array,1,4);
        printArray(array);

        swapIndexQ02(array,2,3);
        printArray(array);
    }


    static int sumOf(int [] array){
        int sum = 0;
        for(int i = 0; i< array.length; i++){
            sum+= array[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        startQ2();
    }
}
