import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp = new int[20][n + 1];
		for (int i = 1; i < n + 1; i++) {
			dp[0][i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][dp[i - 1][j]];
			}
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 20; j++) {
				if ((a & (1 << j)) > 0) {
					x = dp[j][x];
				}
			}
			sb.append(x).append("\n");
		}
		System.out.println(sb);


	}



}