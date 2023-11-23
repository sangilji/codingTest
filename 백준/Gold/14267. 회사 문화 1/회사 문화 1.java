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
	static List<Integer>[] graph;
	static int[] tree;
	static int[] depth;
	static int[] parent;
	static int[] visit;
	static int[] top;
	static int[] in;
	static int[] out;
	static int[] sz;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int count = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		visit = new int[n + 1];
		sz = new int[n + 1];
		graph = new List[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		for (int i = 2; i <=n ; i++) {
			graph[arr[i]].add(i);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sz[a] += b;
		}
		dfs(1);
		for (int i = 1; i <= n; i++) {
			sb.append(sz[i]).append(" ");
		}
		System.out.println(sb);


	}

	private static void dfs(int cur) {
		visit[cur]  = 1;
		for (int i = 0; i < graph[cur].size(); i++) {
			if (visit[graph[cur].get(i)] == 1) {
				continue;
			}
			sz[graph[cur].get(i)] += sz[cur];
			dfs(graph[cur].get(i));
		}

	}

}