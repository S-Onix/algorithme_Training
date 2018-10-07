package doitalgorithm.chpater02;

public class P64 {
    static void copy(int real[], int copy[]){
        for(int i = 0; i < real.length; i++)
            copy[i] = real[i];
    }

    static void rcopy(int real[], int copy[]){
        for(int i =0; i< real.length; i++){
            copy[real.length-i-1] = real[i];
        }
    }
}
