package doitalgorithm.chapter01;

public class P40 {
    static void triangleLBQ15(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleLUQ15(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j+i < n; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    static void triangleRUQ15(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j+i < n; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    static void triangleRBQ15(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j+i < n-1; j++){
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    static void spiraQ16(int n){
        for(int i = 1 ; i < n; i++){
            for(int j = 1; j <= n-i+1; j++){
                System.out.printf(" ");
            }
            for(int j = 1; j<=2*(i-1)+1; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    static void npiraQ17(int n){
        for(int i = 1 ; i < n+1; i++){
            for(int j = 1; j <= n-i+1; j++){
                System.out.printf(" ");
            }
            for(int j = 1; j<=2*(i-1)+1; j++){
                System.out.printf("%d",i%10);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        triangleLBQ15(4);
        System.out.println();
        triangleLUQ15(4);
        System.out.println();
        triangleRUQ15(4);
        System.out.println();
        triangleRBQ15(4);
        System.out.println();
        spiraQ16(11);
        System.out.println();
        npiraQ17(4);
    }
}
