import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;

	static int count = 0;

	static String s;

	static List<Integer>[] graph;
	static int[] visit;
	static int[] arr;
	static int[] size;
	static int[] top;
	static int[] parent;
	static int[] depth;
	static int[] in;
	static int[] out;
	static int[] tree;
	static int[] lazy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		tree = new int[(n + 1) << 2];

		init(1, 1, n);
		int tmp = m - 1;
		sb.append("<");
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				sb.append(get(1, 1, n, tmp + 1)).append(">");
			} else {
				sb.append(get(1, 1, n, tmp + 1)).append(", ");
			}

			tmp += m - 1;
			if (tree[1] != 0) {
				tmp %= tree[1];
			}

		}
		System.out.println(sb);

	}

	private static int get(int node, int start, int end, int index) {
		tree[node]--;
		if (start == end) {
			return start;
		}
		int mid = (start + end) >> 1;
		if (index > tree[node << 1]) {
			return get(node << 1 | 1, mid + 1, end, index - tree[node << 1]);
		}
		return get(node << 1, start, mid, index);
	}

	private static void update(int node, int start, int end, int index) {
		if (index < start || end < index) {
			return;
		}
		if (start == end) {
			tree[node] = 0;
			return;
		}
		int mid = (start + end) >> 1;
		update(node << 1, start, mid, index);
		update(node << 1 | 1, mid + 1, end, index);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = 1;
			return;
		}
		int mid = (start + end) >> 1;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

}