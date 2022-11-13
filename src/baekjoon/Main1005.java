package baekjoon;

import java.util.Scanner;

public class Main1005 {
	static long[] dp;
	static int[] d;
	static int[][] order;
	static int[] inDegree = new int[1001];

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int N = s.nextInt();
			dp = new long[N];
			int K = s.nextInt();
			d = new int[N];
			order = new int[K][2];

			for (int j = 0; j < N; j++) {
				d[j] = s.nextInt();
			}
			for (int j = 0; j < K; j++) {
				order[j][0] = s.nextInt();
				order[j][1] = s.nextInt();
				inDegree[order[j][1]]++;
			}
			int W = s.nextInt();
			System.out.println(game(W));
		}
	}

	private static long game(int w) {
		long answer = 0;
		if (dp[w - 1] != 0) {
			return dp[w - 1];
		}
		for (int[] ints : order) {
			if (ints[1] == w) {
				answer = Math.max(answer, game(ints[0]));
				inDegree[w]--;
			}
			if (inDegree[w] == 0) {
				break;
			}
		}
		return dp[w - 1] = answer + d[w - 1];
	}
}
