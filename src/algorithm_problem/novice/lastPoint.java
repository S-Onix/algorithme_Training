package algorithm_problem.novice;

public class lastPoint {
    /**
     *직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때,
     *  나머지 한 점의 좌표를 구하려고 합니다.
     *  점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때,
     *  직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요.
     *  단, 직사각형의 각 변은 x축, y축에 평행하며,
     *  반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
     *
     *
     *
     * */

    public int [] solution(int [][] v){

        //y 좌표 == v[x][1]
       int countX1 = 0;
       int countX2 = 0;
       int countY1 = 0;
       int countY2 = 0;
       int x[] = new int [4];
       int y[] = new int [4];
       int tempX , tempY ;
       int tempX2 = 0, tempY2 = 0;



        int []answer = new int[2];
        int []answer2 = new int[2];

        for(int i = 0; i < x.length; i++){
           x[i] = 0;
           y[i] = 0;
       }

       for(int i = 0; i < v.length; i++){
           x[i] = v[i][0];
           y[i] = v[i][1];
       }

       tempX = x[0];
       countX1 = 1;
       tempY = y[0];
       countY1 = 1;

       for(int i = 1; i < 3; i++){
           if( tempX != x[i]){
               tempX2 = x[i];
               countX2++;
           }else
               countX1++;

           if( tempY != y[i]){
               tempY2 = y[i];
               countY2++;
           }else
               countY1++;

       }

       if(countX1 == 1) {
           answer[0] = tempX;
       }

       if ( countX2 ==1){
           answer[0] = tempX2;
       }

        if ( countY1 ==1){
            answer[1] = tempY;
        }
        if ( countY2 ==1){
            answer[1] = tempY2;
        }

        //다른값만 찾으면 되기 때문에 xor 를 이용하여 다른 값을 찾는다
        answer2[0] = v[0][0]^v[1][0]^v[2][0];
        answer2[1] = v[0][1]^v[1][1]^v[2][1];


        return answer2;
    }

    public static void main(String[] args) {
        lastPoint s = new lastPoint();
        int [][] array1 = {{1,4},{3,4},{3,10}};

        s.solution(array1);
    }

}
