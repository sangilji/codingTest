import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[] arr;
	static int[] tree;
	static int[] dp;
	static int min = Integer.MAX_VALUE;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(recur(n) ? "SK" : "CY");

	}

	private static boolean recur(int cur) {
		if (cur <= 0) {
			return true;
		}
		if (cur == 1 || cur == 3) {
			return false;
		}
		if (dp[cur] != -1) {
			return dp[cur] == 1;
		}
		int count = 0;
		if (!recur(cur-1)) {
			count+=1;
		}
		if (!recur(cur-3)) {
			count+=1;
		}
		if (count > 0) {
			dp[cur] = 1;
		}else{
			dp[cur] = 0;
		}
		return count > 0;
	}

}