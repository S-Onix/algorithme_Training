package doitalgorithm.chapter01;

public class P38 {
    static void gugudanQ12(){
        System.out.print("   |");
        for (int i = 1; i <= 9; i++)
            System.out.printf("%3d", i);

        System.out.println("\n---+---------------------------");

        for(int i = 1; i < 10; i++){
            System.out.printf("%2d |",i);
            for(int j = 1; j < 10; j++)
                System.out.printf("%3d",(i*j));
            System.out.println();
        }
    }

    static void sumsumdanQ13(){
        System.out.print("   |");
        for (int i = 1; i <= 9; i++)
            System.out.printf("%3d", i);

        System.out.println("\n---+---------------------------");

        for(int i = 1; i < 10; i++){
            System.out.printf("%2d |",i);
            for(int j = 1; j < 10; j++)
                System.out.printf("%3d",(i+j));
            System.out.println();
        }
    }

    static void squareQ14(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        gugudanQ12();
        sumsumdanQ13();
        squareQ14(4);
    }
}
