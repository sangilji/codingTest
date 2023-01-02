package swea;

import java.util.Scanner;

public class Main3234 {
    private static int result;
    private static int right;
    private static int left;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
            }
            boolean[] visit = new boolean[n];
            result = 0;
            right = 0;
            left = 0;
            dfs(weight, visit, 0);
            System.out.printf("#%d %d", test_case, result);
        }
    }

    private static void dfs(int[] weight, boolean[] visit, int depth) {
        if (depth == weight.length) {
            result++;
            return;
        }
        for (int i = 0; i < weight.length; i++) {
            if (visit[i]) {
                continue;
            }
            if (weight[i] + right <= left) {
                visit[i] = true;
                right += weight[i];
                dfs(weight, visit, depth + 1);
                right -= weight[i];
            }
            visit[i] = true;
            left += weight[i];
            dfs(weight, visit, depth + 1);
            left -= weight[i];
            visit[i] = false;
        }
    }
}
