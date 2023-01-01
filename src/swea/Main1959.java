package swea;

import java.util.Scanner;

public class Main1959 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            int max = 0;
            if (n < m) {
                for (int i = 0; i <= m - n; i++) {
                    int tmp = 0;
                    for (int j = 0; j < n; j++) {
                        tmp += b[i + j] * a[j];
                    }
                    max = Math.max(max, tmp);
                }
            } else {
                for (int i = 0; i <= n - m; i++) {
                    int tmp = 0;
                    for (int j = 0; j < m; j++) {
                        tmp += a[i + j] * b[j];
                    }
                    max = Math.max(max, tmp);
                }
            }
            System.out.println("#" + test_case + " " + max);
            /////////////////////////////////////////////////////////////////////////////////////////////
            /*
                 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
             */
            /////////////////////////////////////////////////////////////////////////////////////////////

        }
    }
}
