import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


	static int n;
	static int m;
	static List<int[]>[] nodes;
	static List<Integer>[] v;
	static List<int[]> edges;
	static int[] in;
	static int[] out;
	static int[] parent;
	static int[] tree;
	static int[] costs;
	static int[] top;
	static int[] size;
	static int[] depth;
	static int[] visit;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		nodes = new List[n + 1];
		visit = new int[n + 1];
		costs = new int[n + 1];
		top = new int[n + 1];
		parent = new int[n + 1];
		size = new int[n + 1];
		depth = new int[n + 1];
		in = new int[n + 1];
		// out = new int[n + 1];
		tree = new int[(n + 1) << 2];
		edges = new ArrayList<>();
		v = new List[n + 1];
		for (int i = 1; i < n + 1; i++) {
			nodes[i] = new ArrayList<>();
			v[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodes[a].add(new int[] {b, cost});
			nodes[b].add(new int[] {a, cost});
			edges.add(new int[] {a, b});
		}
		dfs(1);
		dfs2(1);
		dfs3(1);

		for (int i = 1; i <= n; i++) {
			update(1, 1, n, in[i], costs[i]);
		}
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int index = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				int a = edges.get(index-1)[0];
				int b = edges.get(index-1)[1];
				if (depth[a] < depth[b]) {
					int tmp = a;
					a = b;
					b = tmp;
				}
				update(1, 1, n, in[a], value);
			} else {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				sb.append(query(u, v)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static int query(int a, int b) {
		int max = 0;
		while (top[a] != top[b]) {
			if (depth[top[a]] < depth[top[b]]) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			max = Math.max(max, get(1, 1, n, in[top[a]], in[a]));
			a = parent[top[a]];
		}
		if (a == b) {
			return max;
		}
		if (depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		max = Math.max(max, get(1, 1, n, in[a] + 1, in[b]));
		return max;
	}

	private static int get(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) >> 1;
		return Math.max(get(node << 1, start, mid, left, right), get(node << 1 | 1, mid + 1, end, left, right));
	}

	private static void update(int node, int start, int end, int index, int value) {
		if (index < start || end < index) {
			return;
		}
		if (start == end) {
			tree[node] = value;
			return;
		}
		int mid = (start + end) >> 1;
		update(node << 1, start, mid, index, value);
		update(node << 1 | 1, mid + 1, end, index, value);
		tree[node] = Math.max(tree[node << 1], tree[node << 1 | 1]);
	}

	private static void dfs(int cur) {
		visit[cur] = 1;
		for (int i = 0; i < nodes[cur].size(); i++) {
			if (visit[nodes[cur].get(i)[0]]==1) {
				costs[cur] = nodes[cur].get(i)[1];
				continue;
			}
			v[cur].add(nodes[cur].get(i)[0]);
			dfs(nodes[cur].get(i)[0]);
		}
	}

	private static void dfs2(int cur) {
		size[cur] = 1;
		for (int i = 0; i < v[cur].size(); i++) {
			depth[v[cur].get(i)] = depth[cur] + 1;
			parent[v[cur].get(i)] = cur;
			dfs2(v[cur].get(i));
			size[cur] += size[v[cur].get(i)];
			if (size[v[cur].get(0)] < size[v[cur].get(i)]) {
				swap(v[cur], i);
			}
		}
	}

	private static void dfs3(int cur) {
		in[cur] = ++count;
		for (int i = 0; i < v[cur].size(); i++) {
			if (i == 0) {
				top[v[cur].get(i)] = top[cur];
			} else {
				top[v[cur].get(i)] = v[cur].get(i);
			}
			dfs3(v[cur].get(i));
		}
		// out[cur] = count;
	}

	private static void swap(List<Integer> arr, int b) {
		Collections.swap(arr, 0, b);
	}

}