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
	static List<Integer>[] nodes;
	static Map<Long, Integer> map = new HashMap<>();
	static int[] in;
	static int[] out;
	static long[] arr;
	static long[] tree;
	static long[] tree1;
	static long[] lazy;
	static int SIZE = 200_000;
	static String s;
	static int count = 0;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nodes = new List[SIZE + 1];
		in = new int[SIZE + 1];
		out = new int[SIZE + 1];
		tree = new long[(SIZE + 1) << 2];

		for (int i = 1; i <= SIZE; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp == -1) {
				continue;
			}
			nodes[tmp].add(i);
		}
		st = new StringTokenizer(br.readLine());
		int[] start = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			start[i] = Integer.parseInt(st.nextToken());
		}

		int[][] query = new int[m][];
		for (int i = 0; i < m; i++) {
			query[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			if (query[i][0] == 1) {
				n++;
				nodes[query[i][1]].add(query[i][2]);
			}
		}
		dfs(1);

		for (int i = 1; i < start.length; i++) {
			if (start[i] == 0) {
				continue;
			}
			update(1, 1, n, in[i], start[i]);
		}

		for (int i = 0; i < m; i++) {
			if (query[i][0] == 1) {
				update(1, 1, n, in[query[i][2]], query[i][3]);

			} else {
				long result = get(1, 1, n, in[query[i][1]], out[query[i][1]]);
				if (result == 0) {
					sb.append(-1).append("\n");
				}else {
					sb.append(result).append("\n");
				}
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
		int mid = (start + end) >> 1;
		return get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right);
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

	private static void dfs(int current) {
		in[current] = ++count;
		for (Integer i : nodes[current]) {
			dfs(i);
		}
		out[current] = count;
	}

}