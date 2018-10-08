package algorithm_problem.sort;

public class KNum {

    public int sortArray(int [] array, int index){
        for(int i = 0 ; i < array.length; i++){
            for(int j = i+1; j <array.length;j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array[index-1];
    }

    public int [] solution(int[] array, int [][] commands){
        int answer[] = new int[commands.length];

        for(int i = 0; i < commands.length; i++){

            int start = commands[i][0];
            int end = commands[i][1];
            int index = commands[i][2];

            int temp[] = new int[end-start+1];

            for(int arrayIndex = start-1 ; arrayIndex < end; arrayIndex++){
                temp[arrayIndex - start + 1] = array[arrayIndex];
            }
            answer[i] = sortArray(temp, index);
        }

        for(int i = 0 ; i < answer.length;i++){
            System.out.print(answer[i]+ " ");
        }

        return answer;
    }

    public static void main(String[] args) {
        KNum k = new KNum();
        int array[] = {1,5,2,6,3,7,4};
        int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};

        k.solution(array, commands);
    }
}
