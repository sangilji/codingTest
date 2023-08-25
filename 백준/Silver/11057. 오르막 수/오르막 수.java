import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] dp;
	static int MOD = 10_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][10];
		for (int i = 0; i < n+1; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(recur(0, 0));
	}

	private static int recur(int depth, int current) {
		if (depth > n) {
			return 0;
		}
		if (depth == n) {
			return 1;
		}
		if (dp[depth][current] != -1) {
			return dp[depth][current];
		}
		dp[depth][current] = 0;
		for (int i = current; i < 10; i++) {
			dp[depth][current] = (dp[depth][current] + recur(depth + 1, i)) % MOD;
		}
		return dp[depth][current] % MOD;
	}

}