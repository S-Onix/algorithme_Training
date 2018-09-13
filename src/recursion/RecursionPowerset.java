package recursion;

public class RecursionPowerset {
    public static void main(String [] args){
        powerset(0,0);
    }

    private static int [] set = {1,5,3,4};
    private static int LEVEL = set.length;
    private static int [] subSet = new int [LEVEL];

    public static void powerset(int level, int subSetLen){
        //끝까지 검사한 경우
        if(level == LEVEL){
            for(int i = 0; i < subSetLen; i++){
                System.out.print(subSet[i] + " ");
            }
            System.out.println();
            return;
        }
        powerset(level+1, subSetLen);
        //현재 레벨의 원소를 부분집합에 포함
        subSet[subSetLen++] = set[level];
        powerset(level+1,subSetLen);
    }
}
