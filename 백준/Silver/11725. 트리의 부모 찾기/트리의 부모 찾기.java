import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int INF = 2_000_000_000;
	static int n;
	static int m;
	static int x;
	static int y;

	static int[] arr;
	static int[][] visit;
	static List<Integer> list = new ArrayList<>();
	static List<Integer>[] graph;
	static int[] parent;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		graph = new List[n + 1];
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		dfs(1, 0);
		for (int i = 2; i <= n; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);

	}

	private static void dfs(int cur, int prev) {

		for (int i = 0; i < graph[cur].size(); i++) {
			if (graph[cur].get(i) == prev) {
				continue;
			}
			parent[graph[cur].get(i)] = cur;
			dfs(graph[cur].get(i), cur);
		}
	}

}