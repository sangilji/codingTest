import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int k;
	static int m;

	static long[] arr;

	static long[] tree_min;
	static long[] tree_max;
	static long[] lazy;

	static int count = 0;
	static long[][] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new long[n + 1];
			for (int j = 0; j <= n; j++) {
				arr[j] = j;
			}
			tree_min = new long[(n + 1) << 2];
			tree_max = new long[(n + 1) << 2];
			init(1, 1, n);
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()) + 1;
				int c = Integer.parseInt(st.nextToken()) + 1;
				if (a == 0) {
					long tmp = arr[b];
					arr[b] = arr[c];
					arr[c] = tmp;
					update(1, 1, n, b, arr[b]);
					update(1, 1, n, c, arr[c]);
				} else {
					long max = get_max(1, 1, n, b, c);
					long min = get_min(1, 1, n, b, c);
					if (max == c && min == b) {
						sb.append("YES").append("\n");
					} else {
						sb.append("NO").append("\n");
					}
				}

			}

		}

		System.out.println(sb);

	}

	private static long get_min(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 1000000000;
		}
		if (left <= start && end <= right) {
			return tree_min[node];
		}
		int mid = (start + end) >> 1;
		return Math.min(get_min(node << 1, start, mid, left, right), get_min(node << 1 | 1, mid + 1, end, left, right));
	}

	private static long get_max(int node, int start, int end, int left, int right) {

		if (right < start || end < left) {
			return -1;
		}
		if (left <= start && end <= right) {
			return tree_max[node];
		}
		int mid = (start + end) >> 1;
		return Math.max(get_max(node << 1, start, mid, left, right), get_max(node << 1 | 1, mid + 1, end, left, right));
	}

	private static void update(int node, int start, int end, int index, long value) {
		if (index < start || end < index) {
			return;
		}
		if (start == end) {
			tree_min[node] = value;
			tree_max[node] = value;
			return;
		}
		int mid = (start + end) >> 1;
		update(node << 1, start, mid, index, value);
		update(node << 1 | 1, mid + 1, end, index, value);
		tree_min[node] = Math.min(tree_min[node << 1], tree_min[node << 1 | 1]);
		tree_max[node] = Math.max(tree_max[node << 1], tree_max[node << 1 | 1]);
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree_min[node] = arr[start];
			tree_max[node] = arr[start];
			return;
		}
		int mid = (start + end) >> 1;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		tree_min[node] = Math.min(tree_min[node << 1], tree_min[node << 1 | 1]);
		tree_max[node] = Math.max(tree_max[node << 1], tree_max[node << 1 | 1]);
	}
/*
5 2 3
1
2
3
4
5
1 1 5 1
2 1 5
2 2 2
1 1 5 -1
2 1 1
 */
}