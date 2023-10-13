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


	static long[]tree;
	static long[] lazy;

	static int min = Integer.MAX_VALUE;
	static int[][] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[1000001];
		arr2 = new int[n + 1];
		tree = new long[(n + 1) << 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[tmp] = i;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr2[i] = arr[tmp];
		}
		long result = 0;
		for (int i = 1; i <= n; i++) {
			result += get(1, 1, n, arr2[i], n);
			update(1, 1, n, arr2[i], 1);
		}
		System.out.println(result);

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
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	private static long get(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) >> 1;
		return get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right);
	}

}