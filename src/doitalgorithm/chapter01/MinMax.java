package doitalgorithm.chapter01;

public class MinMax {
    static int max4(int input1, int input2, int input3, int input4){
        int max = input1;
        if(max < input2)
            max = input2;
        if(max < input3)
            max = input3;
        if(max < input4)
            max = input4;

        return max;
    }

    static int min3(int input1, int input2, int input3){
        int min = input1;
        if(min > input2)
            min = input2;
        if(min > input3)
            min = input3;
        return min;
    }
}
