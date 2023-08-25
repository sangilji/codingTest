import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<Integer> arr = new ArrayList<>();

	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(recur(0));

	}


	private static int recur(int sum) {
		if (sum > n) {
			return (int)1e9;
		}
		if (sum == n) {
			return 0;
		}
		if (dp[sum] != -1) {
			return dp[sum];
		}
		dp[sum] = (int)1e9;
		for (int i = 1; i * i <= n; i++) {
			if (sum + i * i > n) {
				break;
			}
			dp[sum] = Math.min(recur(sum + i * i)+1, dp[sum]);
		}
		return dp[sum];
	}



}