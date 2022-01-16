package algorithm_fc.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Boj14888 {

    /**
     * 처음 생각한것 : 입력받은 숫자만큼 돌리고 내부 if문을 주어서 operator배열안의 값들을 뺴고 더하는 방식을 취하면 어떨까?
     */

    static int N;
    static int MIN;
    static int MAX;
    static int[] operators;
    static int[] nums;
    static FastScan fc = new FastScan();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = fc.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        for (int i = 1; i <= N; i++) nums[i] = fc.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = fc.nextInt();

        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;
    }

    static int calculate(int val1, int operator, int val2) {
        if (operator == 1) {
            return val1 + val2;
        } else if (operator == 2) {
            return val1 - val2;
        } else if (operator == 3) {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }

    static void reculSolve(int k, int result) {
        if (k == N) {
            MIN = Math.min(result, MIN);
            MAX = Math.max(result, MAX);
        } else {
            // 연산자만큼
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    // 현재 결과값과 다음 결과값을 계산하여 다시 재귀반복해준다.
                    reculSolve(k + 1, calculate(result, cand, nums[k + 1]));
                    operators[cand]++;
                }
            }
        }
    }

    static void reculSolve2(int k, int result) {
        if (k == N) {
            MIN = Math.min(result, MIN);
            MAX = Math.max(result, MAX);
        } else {
            // 입력된 수 만큼 >> 시작되는 위치가 달라져야함(혼자서 함정에 빠진 부분)
            if (operators[1] >= 1) {
                operators[1]--;
                reculSolve2(k + 1, result + nums[k + 1]);
                operators[1]++;
            }
            if (operators[2] >= 1) {
                operators[2]--;
                reculSolve2(k + 1, result - nums[k + 1]);
                operators[2]++;
            }
            if (operators[3] >= 1) {
                operators[3]--;
                reculSolve2(k + 1, result * nums[k + 1]);
                operators[3]++;
            }
            if (operators[4] >= 1) {
                operators[4]--;
                reculSolve2(k + 1, result / nums[k + 1]);
                operators[4]++;
            }
        }
    }

    public static void main(String[] args) {
        input();
        reculSolve2(1, nums[1]);
        sb.append(MAX).append('\n').append(MIN);
        System.out.println(sb.toString());
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScan(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(fileName)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
