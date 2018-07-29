package recursion;

public class RecursionEx3 {
    public static void main(String [] args){

        int data[] = {1,3,5,35,2,7,10};
        System.out.println(recursionFindMax(data, 0, data.length-1));
    }

    public int search(int [] data, int target){
        for(int i=0; i<data.length; i++){
            if(data[i] == target)
                return i;
        }
        return -1;
    }

    public static int recursionSearch(int [] data, int begin, int end, int target){
        if(begin>end)
            return -1;
        else if(target == data[begin])
            return begin;
        else
            return recursionSearch(data, begin+1, end, target);
    }

    public static int otherSequenceSearch(int data[], int begin, int end, int target){
        if(begin>end)
            return -1;
        else{
            int middle = (begin+end)/2;
            if(target == data[middle])
                return middle;
            int index = otherSequenceSearch(data, begin, middle-1, target);
            if(index != -1)
                return index;
            else
                return otherSequenceSearch(data,middle+1, end, target);
        }
    }


    public static int recursionFindMax(int data[], int begin, int end) {
        if (begin == end)
            return data[begin];
        else {
            return Math.max(data[begin], recursionFindMax(data, begin + 1, end));
        }
    }

    public static int recursionBinarySearch(String array[], int begin, int end, String searchData) {
        if(begin>end)
            return -1;
        else{
            int middle = (begin+end)/2;
            int compResult = searchData.compareTo(array[middle]);
            if(compResult == 0)
                return middle;
            else if(compResult < 0)
                return recursionBinarySearch(array, begin, middle-1, searchData);
            else
                return recursionBinarySearch(array, middle+1, end, searchData);

        }
    }
}
