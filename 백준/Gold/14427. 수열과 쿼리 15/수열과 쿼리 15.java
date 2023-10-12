import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int r;
	static int m;

	static long[] arr;

	static long[] tree;
	static long[] tree_index;

	static int count = 0;
	static long[][] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new long[n + 1];
		tree = new long[(n + 1) << 2];
		tree_index = new long[(n + 1) << 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		init(1, 1, n);
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 2) {
				sb.append(tree_index[1]).append("\n");
			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				update(1, 1, n, b, c);
			}
		}
		System.out.println(sb);

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
		if (tree[node << 1] <= tree[node << 1 | 1]) {
			tree[node] = tree[node << 1];
			tree_index[node] = tree_index[node << 1];
		} else {
			tree[node] = tree[node << 1 | 1];
			tree_index[node] = tree_index[node << 1 | 1];
		}
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			tree_index[node] = start;
			return;
		}
		int mid = (start + end) >> 1;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		if (tree[node << 1] <= tree[node << 1 | 1]) {
			tree[node] = tree[node << 1];
			tree_index[node] = tree_index[node << 1];
		} else {
			tree[node] = tree[node << 1 | 1];
			tree_index[node] = tree_index[node << 1 | 1];
		}
	}

}