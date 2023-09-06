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

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;
	static long[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long count = 0;
		int[] prefix_sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			prefix_sum[i] = arr[i] + prefix_sum[i - 1];
		}
		for (int i = 1; i <= n; i++) {
			int tmp = prefix_sum[i];
			if (tmp == m) {
				count++;
			}
			count += map.getOrDefault(tmp - m, 0);
			map.put(prefix_sum[i], map.getOrDefault(prefix_sum[i], 0) + 1);
		}
		System.out.println(count);
	}

}