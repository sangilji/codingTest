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

	static int count = 0;

	static String s;

	static List<Integer>[] graph;
	static int[] visit;
	static List<Integer>[] arr;
	static int[] size;
	static int[] top;
	static int[] parent;
	static int[] depth;
	static int[] in;
	static int[] out;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		graph = new List[n + 1];
		arr = new List[n + 1];
		visit = new int[n + 1];
		size = new int[n + 1];
		top = new int[n + 1];
		parent = new int[n + 1];
		depth = new int[n + 1];
		in = new int[n + 1];
		out = new int[n + 1];
		tree = new int[(n + 1) << 2];
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		dfs(1);
		dfs2(1);
		dfs3(1);

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 1) {
				update(1, 1, n, in[b], b);
			} else {
				sb.append(query(b)).append("\n");
			}
		}
		System.out.println(sb);

	}

	private static int query(int b) {
		int result = 0;
		int a = 1;
		while (top[a] != top[b]) {
			if (depth[top[a]] < depth[top[b]]) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			int val = get(1, 1, n, in[top[a]], in[a]);
			if (val != 0) {
				result = val;
			}
			a = parent[top[a]];
		}
		if (depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int val = get(1, 1, n, in[a], in[b]);
		if (val != 0) {
			result = val;
		}
		if (result == 0) {
			return -1;
		}
		return result;
	}

	private static int get(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) >> 1;
		int a = get(node << 1, start, mid, left, right);
		int b = get(node << 1 | 1, mid + 1, end, left, right);
		if (a != 0) {
			return a;
		}
		return b;
	}

	private static void update(int node, int start, int end, int index, int value) {
		if (index < start || end < index) {
			return;
		}
		if (start == end) {
			tree[node] = tree[node] == value ? 0 : value;
			return;
		}
		int mid = (start + end) >> 1;
		update(node << 1, start, mid, index, value);
		update(node << 1 | 1, mid + 1, end, index, value);
		if (tree[node << 1] > 0) {
			tree[node] = tree[node << 1];
			return;
		}
		if (tree[node << 1 | 1] > 0) {
			tree[node] = tree[node << 1 | 1];
			return;
		}
		tree[node] = 0;
	}

	private static void dfs(int cur) {
		visit[cur] = 1;
		for (int i = 0; i < graph[cur].size(); i++) {
			if (visit[graph[cur].get(i)] == 1) {
				continue;
			}
			arr[cur].add(graph[cur].get(i));
			dfs(graph[cur].get(i));
		}
	}

	private static void dfs2(int cur) {
		size[cur] = 1;
		for (int i = 0; i < arr[cur].size(); i++) {
			depth[arr[cur].get(i)] = depth[cur] + 1;
			parent[arr[cur].get(i)] = cur;
			dfs2(arr[cur].get(i));
			size[cur] += size[arr[cur].get(i)];
			if (size[arr[cur].get(0)] < size[arr[cur].get(i)]) {
				swap(arr[cur], i);
			}
		}
	}

	private static void dfs3(int cur) {
		in[cur] = ++count;
		for (int i = 0; i < arr[cur].size(); i++) {
			if (i == 0) {
				top[arr[cur].get(i)] = top[cur];
			} else {
				top[arr[cur].get(i)] = arr[cur].get(i);
			}
			dfs3(arr[cur].get(i));
		}
		out[cur] = count;
	}

	private static void swap(List<Integer> arr, int i) {
		Collections.swap(arr, 0, i);
	}

}