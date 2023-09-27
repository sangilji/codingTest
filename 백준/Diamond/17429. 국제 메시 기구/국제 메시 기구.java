import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static long MOD = (1L << 32) - 1;
	static int n;
	static int m;
	static long[] arr;
	static int[] in;
	static int[] out;
	static int[] parent;
	static int[] visit;
	static int[] depth;
	static int[] size;
	static int[] top;
	static long[] tree;
	static long[] lazy_mul;
	static long[] lazy_sum;
	static List<Integer>[] graph;

	static List<Integer>[] nodes;

	static int count = 0;

	static int s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new long[n + 1];
		in = new int[n + 1];
		out = new int[n + 1];
		parent = new int[n + 1];
		visit = new int[n + 1];
		depth = new int[n + 1];
		size = new int[n + 1];
		top = new int[n + 1];
		tree = new long[(n + 1) << 2];
		lazy_mul = new long[(n + 1) << 2];
		lazy_sum = new long[(n + 1) << 2];
		graph = new List[n + 1];
		nodes = new List[n + 1];
		Arrays.fill(lazy_mul, 1);
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		dfs(1);
		dfs1(1);
		dfs2(1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if (command == 1) {
				long y = Long.parseLong(st.nextToken());
				update(1, 1, n, in[x], out[x], y, 1);
			}
			if (command == 2) {
				int y = Integer.parseInt(st.nextToken());
				long v = Long.parseLong(st.nextToken());
				updateQuery(x, y, v, 1);
			}
			if (command == 3) {
				long y = Long.parseLong(st.nextToken());
				update(1, 1, n, in[x], out[x], 0, y);
			}
			if (command == 4) {
				int y = Integer.parseInt(st.nextToken());
				long v = Long.parseLong(st.nextToken());
				updateQuery(x, y, 0, v);
			}
			if (command == 5) {
				sb.append(get(1, 1, n, in[x], out[x])).append("\n");
			}
			if (command == 6) {
				int y = Integer.parseInt(st.nextToken());
				sb.append(getQuery(x, y)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static long getQuery(int a, int b) {
		long ret = 0;

		while (top[a] != top[b]) {
			if (depth[top[a]] < depth[top[b]]) {
				int tmp = a;
				a = b;
				b = tmp;

			}
			ret += get(1, 1, n, in[top[a]], in[a]);
			ret &= MOD;
			a = parent[top[a]];
		}

		if (depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		ret += get(1, 1, n, in[a], in[b]);
		ret &= MOD;
		return ret;
	}

	private static void updateQuery(int a, int b, long sum, long mul) {

		while (top[a] != top[b]) {
			if (depth[top[a]] < depth[top[b]]) {
				int tmp = a;
				a = b;
				b = tmp;

			}
			update(1, 1, n, in[top[a]], in[a], sum, mul);
			a = parent[top[a]];
		}

		if (depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		update(1, 1, n, in[a], in[b], sum, mul);
	}

	private static long get(int node, int start, int end, int left, int right) {
		prop(node, start, end);
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node] & MOD;
		}
		int mid = (start + end) >> 1;
		return (get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right)) & MOD;
	}

	private static void update(int node, int start, int end, int left, int right, long sum, long mul) {
		prop(node, start, end);
		if (right < start || end < left) {
			return;
		}
		if (left <= start && end <= right) {
			tree[node] *= mul;
			tree[node] &= MOD;
			tree[node] += (end - start + 1) * sum;
			tree[node] &= MOD;
			if (start != end) {
				lazy_mul[node << 1] *= mul;
				lazy_mul[node << 1] &= MOD;
				lazy_mul[node << 1 | 1] *= mul;
				lazy_mul[node << 1 | 1] &= MOD;
				lazy_sum[node << 1] *= mul;
				lazy_sum[node << 1] &= MOD;
				lazy_sum[node << 1 | 1] *= mul;
				lazy_sum[node << 1 | 1] &= MOD;
				lazy_sum[node << 1] += sum;
				lazy_sum[node << 1] &= MOD;
				lazy_sum[node << 1 | 1] += sum;
				lazy_sum[node << 1 | 1] &= MOD;
			}
			return;
		}
		int mid = (start + end) >> 1;
		update(node << 1, start, mid, left, right, sum, mul);
		update(node << 1 | 1, mid + 1, end, left, right, sum, mul);
		tree[node] = (tree[node << 1] + tree[node << 1 | 1]) & MOD;
	}

	private static void prop(int node, int start, int end) {
		if (lazy_mul[node] != 1) {
			tree[node] *= lazy_mul[node];
			tree[node] &= MOD;
			if (start != end) {
				lazy_mul[node << 1] *= lazy_mul[node];
				lazy_mul[node << 1] &= MOD;
				lazy_mul[node << 1 | 1] *= lazy_mul[node];
				lazy_mul[node << 1 | 1] &= MOD;
				lazy_sum[node << 1] *= lazy_mul[node];
				lazy_sum[node << 1] &= MOD;
				lazy_sum[node << 1 | 1] *= lazy_mul[node];
				lazy_sum[node << 1 | 1] &= MOD;
			}
			lazy_mul[node] = 1;
		}
		if (lazy_sum[node] != 0) {
			tree[node] += (end - start + 1) * lazy_sum[node];
			tree[node] &= MOD;
			if (start != end) {
				lazy_sum[node << 1] += lazy_sum[node];
				lazy_sum[node << 1] &= MOD;
				lazy_sum[node << 1 | 1] += lazy_sum[node];
				lazy_sum[node << 1 | 1] &= MOD;
			}
			lazy_sum[node] = 0;
		}
	}

	private static void dfs(int cur) {
		visit[cur] = 1;
		for (int i = 0; i < graph[cur].size(); i++) {
			if (visit[graph[cur].get(i)] == 1) {
				continue;
			}
			nodes[cur].add(graph[cur].get(i));
			dfs(graph[cur].get(i));
		}
	}

	private static void dfs1(int cur) {
		size[cur] = 1;
		for (int i = 0; i < nodes[cur].size(); i++) {
			parent[nodes[cur].get(i)] = cur;
			depth[nodes[cur].get(i)] = depth[cur] + 1;

			dfs1(nodes[cur].get(i));
			size[cur] += size[nodes[cur].get(i)];

			if (size[nodes[cur].get(0)] < size[nodes[cur].get(i)]) {
				Collections.swap(nodes[cur], 0, i);
			}
		}
	}

	private static void dfs2(int cur) {
		in[cur] = ++count;
		for (int i = 0; i < nodes[cur].size(); i++) {
			if (i == 0) {
				top[nodes[cur].get(i)] = top[cur];
			} else {
				top[nodes[cur].get(i)] = nodes[cur].get(i);
			}
			dfs2(nodes[cur].get(i));
		}
		out[cur] = count;
	}

}