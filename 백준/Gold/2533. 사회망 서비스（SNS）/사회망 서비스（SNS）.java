import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[][] dp;
	static String[] arr;
	static int[] tree;
	static List<Integer>[] graph;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		graph = new List[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		dp = new int[n + 1][2];
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		recur(1, -1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	private static void recur(int cur, int parent) {
		dp[cur][1] = 1;
		for (int i : graph[cur]) {
			if (i == parent) {
				continue;
			}
			recur(i, cur);
			dp[cur][1] += Math.min(dp[i][0], dp[i][1]);
			dp[cur][0] += dp[i][1];
		}
	}

}