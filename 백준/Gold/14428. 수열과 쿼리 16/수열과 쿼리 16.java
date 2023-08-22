import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;

	static long[] arr;
	static long[] tree;
	static long[] idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new long[n + 10];
		tree = new long[(n + 10) * 4];
		idx = new long[(n + 10) * 4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		init(1, 1, n);
		m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			result = 1000000001;
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int index = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				update(1, 1, n, index, value);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				long[] result = get(1, 1, n, left, right);
				sb.append(result[1]).append("\n");
			}
		}
		System.out.println(sb);

	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			idx[node] = start;
			return;
		}
		int mid = (start + end) / 2;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		if (tree[node << 1] < tree[node << 1 | 1]) {
			tree[node] = tree[node << 1];
			idx[node] = idx[node << 1];
		} else if (tree[node << 1] > tree[node << 1 | 1]) {
			tree[node] = tree[node << 1 | 1];
			idx[node] = idx[node << 1 | 1];
		} else {
			tree[node] = tree[node << 1 | 1];
			idx[node] = Math.min(idx[node << 1], idx[node << 1 | 1]);
		}
	}

	static int result;

	private static long[] get(int node, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return new long[] {1000000001L, 0};
		}
		if (left <= start && end <= right) {

			return new long[] {tree[node], idx[node]};
		}
		int mid = (start + end) / 2;
		long[] l = get(node << 1, start, mid, left, right);
		long[] r = get(node << 1 | 1, mid + 1, end, left, right);
		if (l[0] < r[0]) {
			return l;
		} else if (l[0] > r[0]) {
			return r;
		} else {
			if (l[1] < r[1])
				return l;
			return r;
		}
	}

	private static void update(int node, int start, int end, int index, long value) {
		if (start > index || end < index) {
			return;
		}
		if (start == end) {
			tree[node] = value;
			arr[index] = value;
			return;
		}
		int mid = (start + end) / 2;
		update(node << 1, start, mid, index, value);
		update(node << 1 | 1, mid + 1, end, index, value);
		if (tree[node << 1] < tree[node << 1 | 1]) {
			tree[node] = tree[node << 1];
			idx[node] = idx[node << 1];
		} else if (tree[node << 1] > tree[node << 1 | 1]) {
			tree[node] = tree[node << 1 | 1];
			idx[node] = idx[node << 1 | 1];
		} else {
			tree[node] = tree[node << 1 | 1];
			idx[node] = Math.min(idx[node << 1], idx[node << 1 | 1]);
		}
	}

}