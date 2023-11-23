import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
		n = Integer.parseInt(br.readLine());
		graph = new List[n + 1];
		list = new List[n + 1];
		visit = new int[n + 1];
		parent = new int[n + 1];
		sz = new int[n + 1];
		// tree = new int[(n + 1) << 2];
		depth = new int[n + 1];
		top = new int[n + 1];
		in = new int[n + 1];
		out = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		dfs(1);
		dfs2(1);
		dfs3(1);
		m = Integer.parseInt(br.readLine());
		// init(1, 1, n);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(query(a, b)).append("\n");
		}
		System.out.println(sb);

	}

	// private static void init(int node, int start, int end) {
	// 	if (start == end) {
	// 		tree[node] = parent[start];
	// 		return;
	// 	}
	// 	int mid = (start + end) >> 1;
	// 	init(node << 1, start, mid);
	// 	init(node << 1 | 1, mid + 1, start);
	// 	if (depth[tree[node << 1]] < depth[tree[node << 1 | 1]]) {
	// 		tree[node] = tree[node << 1];
	// 	} else {
	// 		tree[node] = tree[node << 1 | 1];
	// 	}
	// }

	private static int query(int a, int b) {
		while (top[a] != top[b]) {
			if (depth[top[a]] < depth[top[b]]) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			a = parent[top[a]];
		}

		if (depth[a] < depth[b]) {
			return a;
		}
		return b;
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

	private static void dfs2(int cur) {
		sz[cur] = 1;
		for (int i = 0; i < list[cur].size(); i++) {
			depth[list[cur].get(i)] = depth[cur] + 1;
			parent[list[cur].get(i)] = cur;
			dfs2(list[cur].get(i));
			sz[cur] += sz[list[cur].get(i)];
			if (list[cur].get(0) < list[cur].get(i)) {
				Collections.swap(list[cur], 0, i);
			}
		}
	}

	private static void dfs3(int cur) {
		in[cur] = ++count;
		for (int i = 0; i < list[cur].size(); i++) {
			if (i == 0) {
				top[list[cur].get(i)] = top[cur];
			} else {
				top[list[cur].get(i)] = list[cur].get(i);
			}
			dfs3(list[cur].get(i));
		}
		out[cur] = count;
	}

}