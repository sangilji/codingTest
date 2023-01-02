package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2565 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = s.nextInt();
            a[i][1] = s.nextInt();
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int result = 0;
        int result1 = 0;
        int tmp = a[0][0];
        for (int i = 1; i < n; i++) {
            if (tmp > a[i][0]) {
                result++;
            } else {
                tmp = a[i][0];
            }
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        tmp = a[0][0];
        for (int i = 1; i < n; i++) {
            if (tmp > a[i][1]) {
                result1++;
            } else {
                tmp = a[i][1];
            }
        }
        System.out.println(Math.min(result1, result));
    }
}
