import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[] arr;
	static int[] tree;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		tree = new int[(n + 1) << 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1, 1, n);
		System.out.println(query(1, n));

	}

	private static long query(int start, int end) {
		int min = get(1, 1, n, start, end);
		long result = (long)(end - start + 1) * arr[min];
		if (min + 1 <= end) {
			result = Math.max(result, query(min + 1, end));
		}
		if (min - 1 >= start) {
			result = Math.max(result, query(start, min - 1));
		}
		return result;
	}

	private static int get(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) >> 1;
		int a = get(node << 1, start, mid, left, right);
		int b = get(node << 1 | 1, mid + 1, end, left, right);
		if (arr[a] == 0) {
			return b;
		}
		if (arr[b] == 0) {
			return a;
		}
		if (arr[a] <= arr[b]) {
			return a;
		}
		return b;
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = start;
			return;
		}
		int mid = (start + end) >> 1;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		if (arr[tree[node << 1]] <= arr[tree[node << 1 | 1]]) {
			tree[node] = tree[node << 1];
		} else {
			tree[node] = tree[node << 1 | 1];
		}
	}

}