import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[] arr;

	static int count = 0;

	static int s;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new long[100001][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][3] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		n = Integer.parseInt(br.readLine());
		for (int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3])%MOD;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3])%MOD;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2])%MOD;
		}
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			long result = 0;
			for (int j = 1; j <= 3; j++) {
				result += dp[tmp][j];
			}
			sb.append(result%MOD).append("\n");

		}
		System.out.println(sb);

	}

}