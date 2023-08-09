import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int k;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n + 1][k + 1];
		System.out.println(recur(0, 0));
	}

	private static int recur(int depth, int sum) {
		if (sum > n) {
			return 0;
		}
		if (depth == k) {
			if (sum == n) {
				return 1;
			}
			return 0;
		}
		if (dp[sum][depth] != 0) {
			return dp[sum][depth] % 1_000_000_000;
		}
		dp[sum][depth] = 0;
		for (int i = 0; i <= n; i++) {
			dp[sum][depth] = (dp[sum][depth] + recur(depth + 1, sum + i)) % 1_000_000_000;
		}
		return dp[sum][depth] % 1_000_000_000;
	}

}