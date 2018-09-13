package reculsion;

public class RecursionEx3 {
    public static void main(String [] args){

    }
    public boolean recursionBinarySearch(int array[], int start, int end, int searchData){
        int mid = (start+end)/2;
        if(array[mid] == searchData){
            return true;
        }else if(searchData > array[mid]){
            return recursionBinarySearch(array, mid, end, searchData);
        }else if(searchData < array[mid]){
            return recursionBinarySearch(array, start, mid, searchData);
        }else
            return false;

    }
}
