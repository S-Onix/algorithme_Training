package doitalgorithm.chapter02;

import java.util.Scanner;

public class P67 {
    static class CardConvRev{
        public int cardConvR(int input, int notation, char [] d){
            int digits = 0;
            String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            do{
                d[digits++] = dchar.charAt(input%notation);
                input/=notation;
            }while(input != 0);

            System.out.println(digits + " 자리입니다");

            return digits;
        }

        public char[] cardConv(int input, int notation, char [] d){
            int digits = cardConvR(input, notation, d);
            char [] tempArray = new char[digits];
            for(int i = 0; i < tempArray.length; i++){
                tempArray[i] = d[digits-1-i];
            }
            return tempArray;
        }
    }

    public static void main(String[] args) {
        CardConvRev card = new CardConvRev();
        Scanner scanner = new Scanner(System.in);

        int no;
        int cd;
        int dno;
        int retry;
        char [] cno = new char[32];
        char [] rcno;

        System.out.println("10진수 변환");
        do{
            do{
                System.out.print("변환하는 음이 아닌 정수 : ");
                no = scanner.nextInt();
            }while(no < 0);

            do{
                System.out.print("몇진수로 변환? ");
                cd = scanner.nextInt();
            }while(cd < 2 || cd > 36);

            dno = card.cardConvR(no, cd, cno);
            rcno = card.cardConv(no,cd, cno);

            System.out.print(cd + "진수로는 ");
            for(int i = dno -1 ; i >= 0; i--){
                System.out.print(cno[i]);
            }
            System.out.print(" 입니다");

            System.out.println();

            System.out.print(cd + "역진수로는 ");
            for(int i = dno -1 ; i >= 0; i--){
                System.out.print(rcno[i]);
            }
            System.out.print(" 입니다");

            System.out.println("한번더? 1 or 2(종료)");
            retry = scanner.nextInt();

        }while(retry == 1);

    }
}
