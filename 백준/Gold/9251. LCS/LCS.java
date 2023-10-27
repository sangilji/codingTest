import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[][] dp;

	static int[] arr;
	static int[] tree;
	static List<Integer>[] graph;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String a = " " + br.readLine();
		String b = " " + br.readLine();
		n = a.length();
		m = b.length();
		dp = new int[n][m];

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[n-1][m-1]);

	}

}