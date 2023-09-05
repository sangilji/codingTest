import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new long[n + 1];
		tree = new long[(n + 1) << 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		init(1, 1, n);
		m = Integer.parseInt(br.readLine());
		int idx = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int index = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				list.add(new int[] {index, value});
			} else {
				int k = Integer.parseInt(st.nextToken());
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				list2.add(new int[] {k, left, right, idx++});
			}
		}
		list2.sort(Comparator.comparingInt(o -> o[0]));
		int start = -1;
		arr2 = new long[m];
		for (int[] i : list2) {
			if (i[0]-1 != start){
				for (int j = start + 1; j < i[0]; j++) {
					int[] tmp = list.get(j);
					update(1, 1, n, tmp[0], tmp[1]);
				}
				start = i[0] - 1;
			}
			arr2[i[3]]= get(1, 1, n, i[1], i[2]);
		}
		for (int i = 0; i < m; i++) {
			if (arr2[i] == 0) {
				break;
			}
			sb.append(arr2[i]).append("\n");
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
		int mid = (start+end)/2;
		return get(node << 1, start, mid, left, right) + get(node << 1 | 1, mid + 1, end, left, right);
	}

	private static void update(int node, int start, int end, int index, int value) {
		if (index < start || end < index) {
			return;
		}
		if (start == end) {
			tree[node] = value;
			arr[index] = value;
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