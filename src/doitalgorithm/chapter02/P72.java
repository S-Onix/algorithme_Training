package doitalgorithm.chapter02;

public class P72 {
    public void primeNumberOtoT(){
        int counter = 0;

        for(int n = 2; n <= 1000; n++){
            int i;
            for(i = 2; i < n; i++){
                counter++;
                if(n%i == 0)
                    break;
            }
            if(n == i)
                System.out.println(n);
        }
        System.out.println("나눈 횟수 : " + counter);
    }

    public void provPrimNumberOtoT(){
        int counter = 0;
        int ptr = 0;
        int[] prime = new int [500];

        prime[ptr++] = 2;

        for(int n = 3; n <= 1000; n+=2){
            int i;
            for(i = 1; i<ptr; i++){
                counter++;
                if(n%prime[i] == 0)
                    break;
            }
            if(ptr == i)
                prime[ptr++] = n;
        }

        int j = 0;
        while(prime[j] != 0){
            System.out.println(prime[j++]);
        }
        System.out.println("나눈 횟수 : "+ counter);
    }


    public static void main(String[] args) {
        P72 p72 = new P72();
        p72.primeNumberOtoT();
        p72.provPrimNumberOtoT();
    }
}
