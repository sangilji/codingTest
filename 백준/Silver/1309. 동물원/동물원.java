import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static long[] tree;
	static int[][] dp;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dp = new int[3][n + 1];

		for (int i = 0; i < 3; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(recur(0, 0));

	}

	static int min;

	private static int recur(int prev, int depth) {
		if (depth == n) {
			return 1;
		}
		if (dp[prev][depth] != -1) {
			return dp[prev][depth];
		}
		int count = 0;
		if (prev != 1) {
			count += recur(1, depth + 1);
			count %= 9901;
		}
		if (prev != 2) {
			count += recur(2, depth + 1);
			count %= 9901;
		}
		count += recur(0, depth + 1);
		count %= 9901;
		return dp[prev][depth] = count;
	}

}