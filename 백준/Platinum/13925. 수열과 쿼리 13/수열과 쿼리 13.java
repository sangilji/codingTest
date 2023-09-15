import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000_007;

	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Long, Integer> map = new HashMap<>();
	static long[] prefix_gcd;
	static long[] suffix_gcd;
	static long[] arr;
	static long[] tree;
	static long[] lazy_mul;
	static long[] lazy_sum;
	static int SIZE = 150_000;
	static String s;
	static int result = 0;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new long[n + 1];
		tree = new long[(n + 1) << 2];
		lazy_mul = new long[(n + 1) << 2];
		Arrays.fill(lazy_mul, 1);
		lazy_sum = new long[(n + 1) << 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		init(1, 1, n);
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				update(1, 1, n, left, right, value, 1);
			} else if (command == 2) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				update(1, 1, n, left, right, 0, value);
			} else if (command == 3) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				update(1, 1, n, left, right, value, 0);
			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				sb.append(get(1, 1, n, left, right)).append("\n");
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
		int mid = (start + end) >> 1;
		return (get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right)) % MOD;
	}

	private static void update(int node, int start, int end, int left, int right, long sum, long mul) {
		prop(node, start, end);
		if (right < start || end < left) {
			return;
		}
		if (left <= start && end <= right) {
			tree[node] *= mul;
			tree[node] %= MOD;
			tree[node] += ((end - start + 1) * sum) % MOD;
			tree[node] %= MOD;

			if (start != end) {
				lazy_mul[node << 1] = (lazy_mul[node << 1] * mul) % MOD;
				lazy_mul[node << 1 | 1] = (lazy_mul[node << 1 | 1] * mul) % MOD;
				lazy_sum[node << 1] *= mul;
				lazy_sum[node << 1] %= MOD;
				lazy_sum[node << 1 | 1] *= mul;
				lazy_sum[node << 1 | 1] %= MOD;
				lazy_sum[node << 1] = (lazy_sum[node << 1] + sum) % MOD;
				lazy_sum[node << 1 | 1] = (lazy_sum[node << 1 | 1] + sum) % MOD;

			}
			return;
		}
		int mid = (start + end) >> 1;
		update(node << 1, start, mid, left, right, sum, mul);
		update(node << 1 | 1, mid + 1, end, left, right, sum, mul);
		tree[node] = (tree[node << 1] + tree[node << 1 | 1]) % MOD;
	}

	private static void prop(int node, int start, int end) {
		if (lazy_mul[node] != 1) {
			tree[node] *= lazy_mul[node];
			tree[node] %= MOD;
			if (start != end) {
				lazy_mul[node << 1] = (lazy_mul[node << 1] * lazy_mul[node]) % MOD;
				lazy_mul[node << 1 | 1] = (lazy_mul[node << 1 | 1] * lazy_mul[node]) % MOD;
				lazy_sum[node << 1] *= lazy_mul[node];
				lazy_sum[node << 1] %= MOD;
				lazy_sum[node << 1 | 1] *= lazy_mul[node];
				lazy_sum[node << 1 | 1] %= MOD;
			}
			lazy_mul[node] = 1;
		}
		if (lazy_sum[node] != 0) {
			tree[node] = (tree[node] + ((end - start + 1) * lazy_sum[node]) % MOD) % MOD;
			if (start != end) {
				lazy_sum[node << 1] = (lazy_sum[node << 1] + lazy_sum[node]) % MOD;
				lazy_sum[node << 1 | 1] = (lazy_sum[node << 1 | 1] + lazy_sum[node]) % MOD;
			}
			lazy_sum[node] = 0;
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
		tree[node] = (tree[node << 1] + tree[node << 1 | 1]) % MOD;
	}

}