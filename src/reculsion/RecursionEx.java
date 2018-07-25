package reculsion;

public class RecursionEx {
    public static void main(String[] args) {
        int n = 4;
        func(n);
        System.out.println(recursionAddOneToN(n));


    }

    public static void func(int n) {
        if (n <= 0) return;
        else {
            System.out.println(n);
            func(n - 1);
        }

    }

    //1~n까지 더하는 함수
    public static int recursionAddOneToN(int n) {
        if (n == 0)
            return 0;
        else
            return n + recursionAddOneToN(n - 1);
    }

    //factorial
    public static int recursionFactorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * recursionFactorial(n - 1);
    }

    //double power(X의 N승 계산)
    public static double recursionPow(double x, int n) {
        if (n == 0)
            return 1;
        else
            return x * recursionPow(x, n - 1);
    }

    //Fibonacci Number
    public static int recursionFibo(int n){
        if (n < 2)
            return n;
        else
            return recursionFibo(n-1)+recursionFibo(n-2);
    }

    //최대공약수
    public static int recursionEuclid(int num1, int num2){
        if( num2 == 0)
            return num1;
        else return recursionEuclid(num2, num1%num2);
    }

}
