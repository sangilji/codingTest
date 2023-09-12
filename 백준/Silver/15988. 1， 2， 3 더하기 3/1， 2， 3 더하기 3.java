import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 100_000;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		n = 1000000;
		dp = new int[n + 1];
		dp[0] = 1;
		for (int j = 0; j <= n; j++) {
			for (int k = 1; k <= 3; k++) {
				if (j - k >= 0) {
					dp[j] = (dp[j] + dp[j - k]) % MOD;
				}
			}
		}
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");

		}
		System.out.println(sb);

	}

}