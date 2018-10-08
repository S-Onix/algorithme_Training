package doitalgorithm.chapter03;

public class P117 {
    public int searchIdex(int [] a, int n, int key, int[]  idx){
        int count = 0;
        for(int i = 0 ; i < n; i++){
            if(a[i] == key) {
                idx[count++] = i;
            }
        }
        return count;
    }

    public int binarySearchX(int [] array, int n, int key){
        int startPoint = 0;
        int endPoint = n-1;
        int midPoint;
        int count = 0;
        int temp[] = new int[n];
        for(int i = 0 ; i < temp.length; i++){
            temp[i] = -1;
        }

        while(startPoint <= endPoint){
            midPoint = (startPoint+endPoint)/2;
            if(array[midPoint] == key) {
                temp[count++] = midPoint;
                endPoint = midPoint -1;
            }
            else if(array[midPoint] > key){
                endPoint = midPoint-1;
            }else if(array[midPoint] < key){
                startPoint = midPoint+1;
            }
        }

        int minPoint = temp[0];
        for(int i = 1 ; i < temp.length; i++){
            if(temp[i] == -1)
                break;
            if(minPoint > temp[i]){
                minPoint = temp[i];
            }
        }

        System.out.println(minPoint);
        return minPoint;
    }

    public static void main(String[] args) {
        P117 p117 = new P117();

        int array[] = {1,3,5,7,7,7,7,8,8,9,9};
        p117.binarySearchX(array, 11, 7);
    }
}

