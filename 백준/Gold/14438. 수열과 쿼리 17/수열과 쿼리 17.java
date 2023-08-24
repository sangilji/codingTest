import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new long[n + 10];
		tree = new long[(n + 10) * 4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		init(1, 1, n);
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int index = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				update(1, 1, n, index, value);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				sb.append(get(1, 1, n, left, right)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void init(int node, int start, int end) {

		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		tree[node] = Math.min(tree[node << 1], tree[node << 1 | 1]);
	}

	private static void update(int node, int start, int end, int index, long value) {
		if (index < start || index > end) {
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
		tree[node] = Math.min(tree[node << 1], tree[node << 1 | 1]);
	}

	private static long get(int node, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return 1000000001L;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return Math.min(get(node << 1, start, mid, left, right), get(node << 1 | 1, mid + 1, end, left, right));
	}

}