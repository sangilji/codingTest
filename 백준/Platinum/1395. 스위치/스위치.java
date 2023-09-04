import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static List<Integer> list = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static long[] arr;
	static long[] tree;
	static long[] lazy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new long[n + 10];
		tree = new long[(n + 10) * 4];
		lazy = new long[(n + 10) * 4];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			if (command == 0) {
				update(1, 1, n, left, right);
			} else {
				sb.append(get(1, 1, n, left, right)).append("\n");
			}
			// System.out.println(Arrays.toString(tree));
		}
		System.out.println(sb);

	}
/*
4 3
0 1 4
0 3 4
1 1 3
 */
	private static long get(int node, int start, int end, int left, int right) {
		lazy(node, start, end);
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right);
	}

	private static void update(int node, int start, int end, int left, int right) {
		lazy(node, start, end);
		if (right < start || end < left) {
			return;
		}
		if (left <= start && end <= right) {
			tree[node] = (end - start + 1) - tree[node];
			if (start != end) {
				lazy[node << 1] = (lazy[node << 1] + 1)%2;
				lazy[node << 1 | 1] = (lazy[node << 1|1] + 1)%2;
			}
			return;
		}
		int mid = (start + end) / 2;
		update(node << 1, start, mid, left, right);
		update(node << 1 | 1, mid + 1, end, left, right);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	private static void lazy(int node, int start, int end) {
		if (lazy[node] != 0) {
			tree[node] =(end - start + 1) - tree[node];
			if (start != end) {
				lazy[node << 1] = (lazy[node<<1] +1)%2;
				lazy[node << 1 | 1] = (lazy[node<<1 | 1] +1)%2;
			}
			lazy[node] = 0;
		}
	}

}