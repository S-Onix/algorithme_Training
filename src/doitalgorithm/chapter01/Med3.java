package doitalgorithm.chapter01;

public class Med3 {
    static int med(int input1, int input2, int input3){
        if(input1 >= input2) {
            if (input2 >= input3)
                return input2;
            else if (input3 >= input1)
                return input1;
            else
                return input3;
        }else if(input1 > input3)
            return input1;
        else if(input3 > input2)
            return input2;
        else
            return input3;

    }
}
