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
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static long[] arr;
	static long[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new long[n + 1];
		tree = new long[(n + 1) << 2];
		lazy = new long[(n + 1) << 2];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			update(1, 1, n, i, i, arr[i] - arr[i - 1]);
		}

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				update(1, 1, n, left, right, 1);
				update(1, 1, n, right + 1, right + 1, -(right - left + 1));
			} else {
				int index = Integer.parseInt(st.nextToken());
				sb.append(get(1, 1, n, 1, index)).append("\n");
			}
		}

		System.out.println(sb);

	}

	private static long get(int node, int start, int end, int left, int right) {
		prop(node, start, end);
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right);
	}

	private static void update(int node, int start, int end, int left, int right, long value) {
		prop(node, start, end);
		if (right < start || end < left) {
			return;
		}
		if (left <= start && end <= right) {

			tree[node] += (end - start + 1) * value;
			if (start != end) {
				lazy[node << 1] += value;
				lazy[node << 1 | 1] += value;

			}
			return;
		}
		int mid = (start + end) / 2;
		update(node << 1, start, mid, left, right, value);
		update(node << 1 | 1, mid + 1, end, left, right, value);
		tree[node] = tree[node << 1 | 1] + tree[node << 1];
	}

	private static void prop(int node, int start, int end) {
		if (lazy[node] != 0) {
			tree[node] += lazy[node] * (end - start + 1);
			if (start != end) {
				lazy[node << 1] += lazy[node];
				lazy[node << 1 | 1] += lazy[node];

			}
			lazy[node] = 0;
		}
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

}