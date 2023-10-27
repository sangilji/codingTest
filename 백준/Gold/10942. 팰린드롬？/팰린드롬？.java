import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[][] dp;

	static int[] arr;
	static int[] tree;
	static List<Integer>[] graph;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(recur(a, b)).append("\n");
		}
		System.out.println(sb);

	}

	private static int recur(int a, int b) {
		if (a > b) {
			return 1;
		}
		if (arr[a] != arr[b]) {
			return 0;
		}
		if (dp[a][b] != -1) {
			return dp[a][b];
		}

		return dp[a][b] = recur(a + 1, b - 1);
	}

}