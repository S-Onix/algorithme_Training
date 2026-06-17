package programmers;

public class RotateMetrix {
    public String[] solution(String[] matrix) {
        // 여기에 코드를 작성하세요
        int n = matrix.length;
        int m = matrix[0].length();

        char [][] result = new char[m][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                result[j][n-1-i] = matrix[i].charAt(j);
            }
        }

        String[] answer = new String[m];
        for (int i = 0; i < m; i++)
            answer[i] = new String(result[i]);

        return answer;


        /**
         *   0 1 2      6 3 0     (0,0)->(0,2) / (0,1)->(1,2) / (0,2)->(2,2)
         *   3 4 5   >> 7 4 1     (1,0)->(0,1)  / (1,1)->(1,1) / (1,2)->(2,1)
         *   6 7 8      8 5 2
         * */
    }
}
