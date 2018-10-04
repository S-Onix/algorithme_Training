package doitalgorithm.chapter01;

public class P30 {
    static int sumQ7(int n){
        int sum = 0;

        for(int i = 1; i <= n ; i++){
            sum+=i;
        }

        return sum;
    }

    static int gausSumQ8(int n){
        return (n+(n+1))/2;
    }

    static int betweenSumQ9(int input1, int input2){
        int sum = 0;

        if(input1 <= input2)
            for(int i = input1 ; i <=input2; i++)
                sum+=i;
        else
            for(int i = input2; i<= input1; i++)
                sum+=i;

        return sum;
    }


}
