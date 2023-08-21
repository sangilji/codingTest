import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int k;
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new long[n + 10];
		tree = new long[(n + 10) * 4];
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(1, 1, n);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int index = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				update(1, 1, n, index, value);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());

				sb.append(get(1, 1, n, left, right)%1_000_000_007).append("\n");
			}
		}
		System.out.println(sb);

	}

	private static long get(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 1L;
		}
		if (start >= left && end <= right) {
			return tree[node] %1_000_000_007; // 추가
		}
		long lsum = get(node * 2, start, (start + end) / 2, left, right);
		long rsum = get(node * 2+1, (start+end)/2 +1, end, left, right);
		return ((lsum%1_000_000_007)*(rsum%1_000_000_007))%1_000_000_007;
	}

	private static void update(int node, int start, int end, int index, long value) {
		if (index < start || index > end) {
			return;
		}

		if (start == end) {
			arr[index] = value;
			tree[node] = value;
			return;
		}

		update(node * 2, start, (start + end) / 2, index, value);
		update(node * 2 + 1, (start + end) / 2 + 1, end, index, value);
		tree[node] = (tree[node * 2] * tree[node * 2 + 1]) %1_000_000_007;
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		init(node * 2, start, (start + end) / 2);
		init(node * 2 + 1, (start + end) / 2 + 1, end);
		tree[node] = (tree[node * 2] * tree[node * 2 + 1]) %1_000_000_007;
	}
}