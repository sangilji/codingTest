import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(recur(a, b) ? 1 : 0).append("\n");
		}
		System.out.println(sb);

	}

	private static boolean recur(int a, int b) {
		if (b < a || a == b) {
			return true;
		}
		if (dp[a][b] != -1) {
			return dp[a][b] == 1;
		}
		boolean bool;
		if (arr[a] == arr[b]) {
			bool = recur(a + 1, b - 1);
		} else {
			dp[a][b] = 0;
			return false;
		}
		if (bool) {
			dp[a][b] = 1;
		} else {
			dp[a][b] = 0;
		}
		return bool;
	}

}