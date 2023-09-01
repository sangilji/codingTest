import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n = 1000000;
	static long m;
	static long[] arr = new long[1000010];
	static long[] tree = new long[1000010 * 4];
	static long[] tree1 = new long[1000010 * 4];
	static long a;
	static long d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		a = Long.parseLong(st.nextToken());
		d = Long.parseLong(st.nextToken());
		arr[1] = a;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + d;
		}
		init(1, 1, n);
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			if (command == 1) {
				sb.append(get(1, 1, n, left, right)).append("\n");
			} else {
				sb.append(get2(1, 1, n, left, right)).append("\n");
			}
		}
		System.out.println(sb);

	}

	private static long get(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start + end) / 2;
		return get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right);
	}

	private static long get2(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree1[node];
		}
		int mid = (start + end) / 2;
		return gcd(get2(node << 1, start, mid, left, right), get2(node << 1 | 1, mid + 1, end, left, right));
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			tree1[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
		tree1[node] = gcd(tree1[node << 1], tree1[node << 1 | 1]);
	}

	private static long gcd(long a, long b) {
		if (a > b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		if (a == 0) {
			return b;
		}
		while (true) {
			if (b % a == 0) {
				return a;
			}
			b %= a;
			long tmp = a;
			a = b;
			b = tmp;
		}
	}

}