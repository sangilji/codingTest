import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static long[] arr;
	static long[] tree;
	static long[] tree1;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new long[n + 10];
		tree = new long[(n + 10) * 4];
		tree1 = new long[(n + 10) * 4];
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		initMax(1, 1, n);
		initMin(1, 1, n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(get1(1, 1, n, a, b)).append(" ");
			sb.append(get(1, 1, n, a, b)).append("\n");
		}
		System.out.println(sb);

	}

	private static void initMax(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		initMax(node * 2, start, (start + end)/2);
		initMax(node * 2 + 1, (start + end) / 2 + 1, end);
		tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
	}

	private static void initMin(int node, int start, int end) {
		if (start == end) {
			tree1[node] = arr[start];
			return;
		}
		initMin(node * 2, start, (start + end)/2);
		initMin(node * 2 + 1, (start + end) / 2 + 1, end);
		tree1[node] = Math.min(tree1[node * 2], tree1[node * 2 + 1]);
	}

	private static long get(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left<=start && right>=end){
			return tree[node];
		}
		long lsum = get(node * 2, start, (start + end) / 2, left, right);
		long rsum = get(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		return Math.max(lsum,rsum);
	}

	private static long get1(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 1000000001L;
		}
		if (left<=start && right>=end){
			return tree1[node];
		}
		long lsum = get1(node * 2, start, (start + end) / 2, left, right);
		long rsum = get1(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
		return Math.min(lsum,rsum);
	}

}