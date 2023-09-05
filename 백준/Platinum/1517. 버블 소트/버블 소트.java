import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static List<Integer> list = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[][] arr;
	static int[] arr2;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][2];
		tree = new int[(n + 1) << 2];
		arr[0][0] = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
		Arrays.sort(arr, Comparator.comparingInt(o->o[0]));
		long count = 0;
		for (int i = 1; i <= n; i++) {
			update(1, 1, n, arr[i][1]);
			count+= get(1, 1, n, arr[i][1] + 1, n);
		}
		System.out.println(count);

		// System.out.println(list);

	}

	private static long get(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = (start+end)/2;
		return get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right);

	}

	private static void update(int node, int start, int end, int index) {
		if (index < start || end < index) {
			return;
		}
		if (start == end) {
			tree[node] = 1;
			return;
		}
		int mid = (start + end) / 2;
		update(node << 1, start, mid, index);
		update(node << 1 | 1, mid + 1, end, index);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

}