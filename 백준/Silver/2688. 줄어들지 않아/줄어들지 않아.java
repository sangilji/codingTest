import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int r;
	static int m;

	static int[] arr;
	static List<Integer>[] graph;
	static List<Integer>[] list;
	static int[] visit;
	static int[] in;
	static int[] out;
	static int[] tree;

	static int count = 0;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = 65;
		dp = new long[10][n+1];

		for (int i = 0; i < 10; i++) {
			Arrays.fill(dp[i], -1);
		}
		recur(0, 0);

		// StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			m = Integer.parseInt(br.readLine());
			int tmp = n - m + 1;
			long sum = 0;
			for (int j = 0; j < 10; j++) {
				sum += dp[j][tmp];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

	private static long recur(int current, int depth) {
		if (depth == n) {
			return dp[current][depth] = 1;
		}
		if (dp[current][depth] != -1) {
			return dp[current][depth];
		}
		long tmp = 0;
		for (int i = current; i <= 9; i++) {
			tmp += recur(i, depth + 1);
		}

		return dp[current][depth] = tmp;
	}

}