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
	static int k;
	static int x;
	static int y;

	static int[] arr;
	static List<Integer>[] list;
	static List<int[]>[] graph;
	static int[] tree;
	static int[] depth1;
	static int[] depth2;
	static int[] parent;
	static int[] visit;
	static int[] top;
	static int[] in;
	static int[] out;
	static int[] sz;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		visit = new int[n + 1];
		depth1 = new int[n + 1];
		depth2 = new int[n + 1];
		graph = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		dfs(1, 0, depth1);
		int max = 0;
		int index = 1;
		for (int i = 1; i <= n; i++) {
			if (max < depth1[i]) {
				max = depth1[i];
				index = i;
			}
		}
		dfs(index, 0, depth1);
		max = 0;
		index = 1;
		for (int i = 1; i <= n; i++) {
			if (max < depth1[i]) {
				max = depth1[i];
				index = i;
			}
		}
		dfs(index, 0, depth2);
		for (int i = 1; i <= n; i++) {
			sb.append(Math.max(depth1[i], depth2[i])).append("\n");
		}

		System.out.println(sb);

	}

	private static void dfs(int cur, int sum, int[] depth) {
		visit[cur] = 1;
		depth[cur] = sum;

		for (int i = 0; i < graph[cur].size(); i++) {
			if (visit[graph[cur].get(i)[0]] == 1) {
				continue;
			}
			dfs(graph[cur].get(i)[0], sum + graph[cur].get(i)[1], depth);
		}
		visit[cur] = 0;
	}

}