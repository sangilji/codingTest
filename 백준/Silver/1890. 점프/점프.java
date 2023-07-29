import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int n;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new long[n][n];
		// for (int i = 0; i < n; i++) {
		// 	Arrays.fill(dp[i], -1);
		// }
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[n - 1][n - 1] = 1;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == n - 1 && j == n - 1) {
					continue;
				}
				if (i + arr[i][j] < n) {
					dp[i][j] = dp[i + arr[i][j]][j];
				}
				if (j + arr[i][j] < n) {

					dp[i][j] += dp[i][j + arr[i][j]];
				}
			}
		}
		System.out.println(dp[0][0]);

		// System.out.println(recur(0, 0));

	}

	private static long recur(int x, int y) {
		if (x >= n || y >= n) {
			return 0;
		}
		if (x == n - 1 && y == n - 1) {
			return 1;
		}
		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		int tmp = arr[x][y];
		return dp[x][y] = recur(x + tmp, y) + recur(x, y + tmp);
	}

}