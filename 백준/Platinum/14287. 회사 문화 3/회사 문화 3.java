import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000_007;

	static int n;
	static int m;
	static List<Integer>[] nodes;
	static Map<Long, Integer> map = new HashMap<>();
	static int[] in;
	static int[] out;
	static long[] arr;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 150_000;
	static String s;
	static int count = 0;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		tree = new long[(n + 1) << 2];
		lazy = new long[(n + 1) << 2];
		nodes = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			nodes[i] = new ArrayList<>();
		}
		in = new int[n + 1];
		out = new int[n + 1];
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp == -1) {
				continue;
			}
			nodes[tmp].add(i);
		}
		dfs(1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			if (command == 1) {
				long value = Long.parseLong(st.nextToken());
				update(1, 1, n, in[index], value);
			} else {
				sb.append(get(1, 1, n, in[index], out[index])).append("\n");
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

	private static void update(int node, int start, int end, int index, long value) {
		if (index < start || end < index) {
			return;
		}
		if (start == end) {
			tree[node] +=value;
			return;
		}
		int mid = (start + end) / 2;
		update(node << 1, start, mid, index, value);
		update(node << 1 | 1, mid + 1, end, index, value);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	private static void dfs(int current) {
		in[current] = ++count;
		for (int next : nodes[current]) {
			dfs(next);
		}
		out[current] = count;
	}

}