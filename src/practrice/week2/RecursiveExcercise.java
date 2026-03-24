package src.practrice.week2;

public class RecursiveExcercise {
    public static void main(String[] args) {
        count(60);
    }

    public static void count(int num) {
        if(num < 0) return;

        System.out.println(num);
        count(num-1);
    }
}
