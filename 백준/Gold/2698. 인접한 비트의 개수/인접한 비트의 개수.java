import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[][][] dp;
	static String[] arr;
	static int[] tree;
	static List<Integer>[] graph;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		dp = new int[101][101][2];
		dp[1][0][0] = 1;
		dp[1][0][1] = 1;

		for (int i = 2; i <= 100; i++) {
			for (int j = 0; j < i; j++) {
				dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
				if (j >= 1) {
					dp[i][j][1] += dp[i - 1][j - 1][1] + dp[i - 1][j][0];
				}else{
					dp[i][j][1] = dp[i - 1][j][0];
				}
			}
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(dp[a][b][0] + dp[a][b][1]).append("\n");
		}
		System.out.println(sb);
	}

}