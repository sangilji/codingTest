import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[] arr;

	static int count = 0;

	static int s;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[n][m + 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		int result =recur(0, s);
		if (result == -2) {
			System.out.println(-1);
			return;
		}
		System.out.println(result);

	}

	private static int recur(int depth, int volume) {
		if (volume < 0 || volume > m) {
			return -2;
		}
		if (depth == n) {
			return volume;
		}
		if (dp[depth][volume] != -1) {
			return dp[depth][volume];
		}
		dp[depth][volume] = Math.max(recur(depth + 1, volume + arr[depth]), recur(depth + 1, volume - arr[depth]));

		return dp[depth][volume];
	}

}