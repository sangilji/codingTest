import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static int[] dp;
	static int min = Integer.MAX_VALUE;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		// m = Integer.parseInt(st.nextToken());
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(recur(0) % 10007);

	}

	private static int recur(int depth) {
		if (depth > n) {
			return 0;
		}
		if (depth == n) {
			return 1;
		}
		if (dp[depth] != -1) {
			return dp[depth];
		}
		return dp[depth] = (recur(depth + 1) + recur(depth + 2))%10007;
	}



}