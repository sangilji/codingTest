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
	static int[] arr = new int[3];
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		n = Integer.parseInt(st.nextToken());
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		if (recur(0)==0) {
			System.out.println(0);
		}else{
			System.out.println(1);
		}

	}

	private static int recur(int sum) {
		if (sum > n) {
			return 0;
		}
		if (sum == n) {
			return 1;
		}
		if (dp[sum] != -1) {
			return dp[sum];
		}
		dp[sum] = 0;
		for (int i = 0; i < 3; i++) {
			dp[sum]+= recur(sum + arr[i]);
		}
		return dp[sum];
	}

}