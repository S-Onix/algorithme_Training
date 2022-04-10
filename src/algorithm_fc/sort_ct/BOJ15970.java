package algorithm_fc.sort_ct;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ15970 {
    static BOJ20291.FastScan scan = new BOJ20291.FastScan();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] a;

    static void input() {
        N = scan.nextInt();
        a = new ArrayList[N + 1];
        for (int color = 1; color <= N; color++) {
            a[color] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N; i++) {
            int coord, color;
            coord = scan.nextInt();
            color = scan.nextInt();
            a[color].add(coord);
        }
    }

    static int toLeft(int color, int idx) {
        if (idx == 0)  // 왼쪽에 더 이상 점이 없는 상태
            return Integer.MAX_VALUE;
        return a[color].get(idx) - a[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        if (idx + 1 == a[color].size())  // 오른쪽에 더 이상 점이 없는 상태
            return Integer.MAX_VALUE;
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    static void solve() {
        for (int color = 1; color <= N; color++)
            Collections.sort(a[color]);

        int ans = 0;
        for (int color = 1; color <= N; color++) {
            for (int i = 0; i < a[color].size(); i++) {
                int left_distance = toLeft(color, i);
                int right_distance = toRight(color, i);
                ans += Math.min(left_distance, right_distance);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
    }




}

class Point implements Comparable<Point>{
    int color;
    int site;

    @Override
    public int compareTo(Point other) {
        if(this.color != other.color)
            return this.color - other.color;

        return this.site - other.site;
    }
}
