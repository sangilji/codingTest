import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static long[] arr;
	static long[] arr2;
	static long[] tree;
	static int SIZE = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new long[SIZE + 1];
		tree = new long[(SIZE + 1) << 2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			if (command == 2) {
				int value = Integer.parseInt(st.nextToken());
				update(1, 1, SIZE, index, value);
			} else {
				int k = kth(1, 1, SIZE, index);
				sb.append(k).append("\n");
				update(1, 1, SIZE, k, -1);
			}
		}
		System.out.println(sb);

	}

	private static int kth(int node, int start, int end, int k) {
		if (start == end) {
			return start;
		}
		int left = (int)tree[node << 1];
		long right = tree[node << 1 | 1];
		int mid = start + (end - start) / 2;
		if (left >= k) {
			return kth(node << 1, start, mid, k);
		}
		return kth(node << 1 | 1, mid + 1, end, k - left);
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

	private static void update(int node, int start, int end, int index, int value) {
		if (index < start || end < index) {
			return;
		}
		if (start == end) {
			arr[index] += value;
			tree[node] += value;
			return;
		}
		int mid = (start + end) / 2;
		update(node << 1, start, mid, index, value);
		update(node << 1 | 1, mid + 1, end, index, value);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		init(node << 1, start, mid);
		init(node << 1 | 1, mid + 1, end);
		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

}