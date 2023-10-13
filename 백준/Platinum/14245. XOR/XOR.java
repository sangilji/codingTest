import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int k;
	static int m;

	static int[] arr;
	static int[] sum;
	static int[] num;
	static int[] arr2;

	static long[] tree;
	static long[] lazy;

	static int min = Integer.MAX_VALUE;
	static int[][] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		tree = new long[(n + 1)<<2];
		lazy = new long[(n + 1)<<2];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1, 1, n);
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				update(1, 1, n, b+1, c+1, d);
			} else {
				sb.append(get(1, 1, n, b+1, b+1)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) >> 1;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		tree[node] = tree[node << 1] ^ tree[node << 1 | 1];
	}

	private static void update(int node, int start, int end, int left, int right, int value) {
		prop(node, start, end);
		if (right < start || end < left) {
			return;
		}
		if (left <= start && end <= right) {
			tree[node] ^= value;
			if (start != end) {
				lazy[node << 1] ^= value;
				lazy[node << 1 | 1] ^= value;
			}
			return;
		}
		int mid = (start + end) >> 1;
		update(node << 1, start, mid, left, right, value);
		update(node << 1 | 1, mid + 1, end, left, right, value);
		tree[node] = tree[node << 1] ^ tree[node << 1 | 1];
	}

	private static void prop(int node, int start, int end) {
		if (lazy[node] != 0) {
			tree[node] ^= lazy[node];
			if (start != end) {
				lazy[node << 1] ^= lazy[node];
				lazy[node << 1 | 1] ^= lazy[node];
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
		return get(node << 1, start, mid, left, right) ^ get(node << 1 | 1, mid + 1, end, left, right);
	}

}