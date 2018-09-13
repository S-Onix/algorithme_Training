package recursion;

public class RecursionEx2 {
    public static void main(String [] args){
        String str = "abcd";
        int length = recursionLength(str);
        int array[] = {1,2,3,4,5,6};
        System.out.println(length);
        recursionPrintString(str);
        System.out.println();
        recursionReversePrintString(str);
        System.out.println();
        recursionBinary(505);
        System.out.println();
        System.out.println(recursionArraySum(array, 6));

    }

    public static int recursionLength(String input){
        if(input.equals(""))
            return 0;
        else return 1+recursionLength(input.substring(1));
    }

    public static void recursionPrintString(String str){
        if(str.length()==0)
            return;
        else{
            System.out.print(str.charAt(0));
            recursionPrintString(str.substring(1));
        }
    }

    public static void recursionReversePrintString(String str){
        if(str.length() == 0){
            return;
        }else {
            recursionReversePrintString(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }
    public static void recursionBinary(int n){
        if(n < 2)
            System.out.print(n);
        else{
            recursionBinary(n/2);
            System.out.print(n%2);
        }
    }

    public static int recursionArraySum(int [] array, int n){
        if(n<=0)
            return 0;
        else
            return array[n-1]+recursionArraySum(array, n-1);
    }
}
