import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[][] dp;
	static String[] arr;
	static int[] tree;
	static int[] visit;
	static List<Integer>[] list;
	static List<Integer>[] graph;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		list = new List[n + 1];
		graph = new List[n + 1];
		visit = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
			graph[i] = new ArrayList<>();
		}
		dp = new int[n + 1][2];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		dfs(1);
		System.out.println(Math.min(recur(1, 0), recur(1, 1)));

	}

	private static void dfs(int cur) {
		visit[cur] = 1;
		for (int i = 0; i < graph[cur].size(); i++) {
			if (visit[graph[cur].get(i)] == 1) {
				continue;
			}
			list[cur].add(graph[cur].get(i));
			dfs(graph[cur].get(i));
		}
	}

	private static int recur(int cur, int status) {
		if (list[cur].size() == 0) {
			return status;
		}
		if (dp[cur][status] != -1) {
			return dp[cur][status];
		}
		dp[cur][status] = status;
		for (int i = 0; i < list[cur].size(); i++) {
			if (status == 1) {
				dp[cur][status] += Math.min(recur(list[cur].get(i), 0), recur(list[cur].get(i), 1));
			} else {
				dp[cur][status] += recur(list[cur].get(i), 1);
			}
		}
		return dp[cur][status];
	}

}