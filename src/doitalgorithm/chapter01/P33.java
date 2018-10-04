package doitalgorithm.chapter01;

import java.util.Scanner;

public class P33 {
    static void doWhileQ10(){
        Scanner scan = new Scanner(System.in);

        System.out.println("a : ");
        int a = scan.nextInt();
        int b= 0;
        while(true){
            System.out.println("b : ");
            b = scan.nextInt();
            if(a<b)
                break;
            System.out.println("a보다 큰 값을 입력하세요");

        }

        System.out.println("b-a = " + (b-a));

    }

    static void Q11(int n){
        int count = 0;
        if(n > 0 ){
            do{
                n/=10;
                count++;
            }while(n>0);
        }else System.out.println("양수를 입력하세요");

        System.out.println("n의 자리수는 " + count + "자리 입니다.");
    }

    public static void main(String[] args) {
        Q11(10000);
        Q11(12);
        Q11(-1);
        Q11(1);
    }
}
