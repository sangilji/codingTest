import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int k;
	static int m;

	static int[] arr;
	static int[] in;
	static int[] out;

	static long[] tree;
	static long[] lazy;

	static List<Integer>[] graph;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		tree = new long[(n + 1) << 2];
		lazy = new long[(n + 1) << 2];
		in = new int[n + 1];
		out = new int[n + 1];
		graph = new List[n + 1];
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		arr[1] = Integer.parseInt(br.readLine());
		for (int i = 2; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b].add(i);
			arr[i] = a;
		}
		dfs(1);

		for (int i = 1; i <= n; i++) {
			update(1, 1, n, in[i], in[i], arr[i]);
		}


		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			if (a.equals("p")) {
				int c = Integer.parseInt(st.nextToken());
				update(1, 1, n, in[b] + 1, out[b], c);
			}else{
				sb.append(get(1, 1, n, in[b], in[b])).append("\n");
			}
		}
		System.out.println(sb);
	}

	static int count = 0;

	private static void dfs(int cur) {
		in[cur] = ++count;
		for (int i = 0; i < graph[cur].size(); i++) {
			dfs(graph[cur].get(i));
		}
		out[cur] = count;
	}


	private static void update(int node, int start, int end, int left, int right, int value) {
		prop(node, start, end);
		if (right < start || end < left) {
			return;
		}
		if (left <= start && end <= right) {
			tree[node] += value;
			if (start != end) {
				lazy[node << 1] += value;
				lazy[node << 1 | 1] += value;
			}
			return;
		}
		int mid = (start + end) >> 1;
		update(node << 1, start, mid, left, right, value);
		update(node << 1 | 1, mid + 1, end, left, right, value);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	private static void prop(int node, int start, int end) {
		if (lazy[node] != 0) {
			tree[node] += lazy[node];
			if (start != end) {
				lazy[node << 1] += lazy[node];
				lazy[node << 1 | 1] += lazy[node];
			}
			lazy[node] = 0;
		}
	}

	private static long get(int node, int start, int end, int left, int right) {
		prop(node, start, end);
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) >> 1;
		return get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right);
	}

}