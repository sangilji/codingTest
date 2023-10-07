import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;

	static int count = 0;

	static String s;

	static List<Integer>[] graph;
	static int[] visit;
	static int[] arr;
	static int[] size;
	static int[] top;
	static int[] parent;
	static int[] depth;
	static int[] in;
	static int[] out;
	static int[] tree;
	static int[] lazy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		tree = new int[(n + 1) << 2];
		lazy = new int[(n + 1) << 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1, 1, n);
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int d = Integer.parseInt(st.nextToken());
				update(1, 1, n, b + 1, c + 1, d);
			} else {
				sb.append(get(1, 1, n, b + 1, c + 1)).append("\n");
			}
		}
		System.out.println(sb);

	}

	private static int get(int node, int start, int end, int left, int right) {
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

	private static void update(int node, int start, int end, int left, int right, int k) {
		prop(node, start, end);
		if (right < start || end < left) {
			return;
		}
		if (left <= start && end <= right) {
			int tmp = end - start + 1;
			if (tmp % 2 == 1) {
				tree[node] ^= k;
			}
			if (start != end) {
				lazy[node << 1] ^= k;
				lazy[node << 1 | 1] ^= k;
			}
			return;
		}
		int mid = (start + end) >> 1;
		update(node << 1, start, mid, left, right, k);
		update(node << 1 | 1, mid + 1, end, left, right, k);
		tree[node] = tree[node << 1] ^ tree[node << 1 | 1];
	}

	private static void prop(int node, int start, int end) {
		if (lazy[node] != 0) {
			int tmp = end - start + 1;
			if (tmp % 2 == 1) {
				tree[node] ^= lazy[node];
			}
			if (start != end) {
				lazy[node << 1] ^= lazy[node];
				lazy[node << 1 | 1] ^= lazy[node];
			}
			lazy[node] = 0;
		}
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

}