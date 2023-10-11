import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int r;
	static int m;

	static int[][] arr;
	static List<Integer>[] graph;
	static List<Integer>[] list;
	static int[] visit;
	static int[] in;
	static int[] out;
	static int[] tree;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new List[n + 1];
		list = new List[n + 1];
		visit = new int[n + 1];
		in = new int[n + 1];
		out = new int[n + 1];
		tree = new int[(n + 1)<<2];
		for (int i = 1; i < n+1; i++) {
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
		dfs(r);
		dfs2(r);

		init(1, 1, n);
		for (int i = 0; i < m; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sb.append(get(1, 1, n, in[tmp], out[tmp])).append("\n");
		}
		System.out.println(sb);

	}

	private static int get(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) >> 1;
		return get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right);
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = 1;
			return;
		}
		int mid = (start + end) >> 1;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
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
		in[cur] = ++count;
		for (int i = 0; i < list[cur].size(); i++) {
			dfs2(list[cur].get(i));
		}
		out[cur] = count;
	}

}