import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static long[] arr;

	static int count = 0;

	static String s;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		dp = new long[n][21];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		System.out.println(recur(1, arr[0]));
	}

	private static long recur(int depth, long sum) {
		if (depth == n - 1) {
			if (sum == arr[depth]) {
				return 1;
			}
			return 0;
		}
		if (sum < 0 || sum > 20) {
			return 0;
		}
		if (dp[depth][(int)sum] != -1) {
			return dp[depth][(int)sum];
		}
		long tmp = 0;
		tmp += recur(depth + 1, sum + arr[depth]);
		tmp += recur(depth + 1, sum - arr[depth]);

		return dp[depth][(int)sum] = tmp;
	}

}