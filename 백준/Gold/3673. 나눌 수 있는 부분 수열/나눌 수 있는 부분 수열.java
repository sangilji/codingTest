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
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Long, Integer> map = new HashMap<>();
	static long[] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 150_000;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new long[m + 1];
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[j] = arr[j - 1] + Integer.parseInt(st.nextToken());
			}
			long result = 0;
			for (int j = 1; j <= m; j++) {
				if (arr[j] < n) {
					map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
					continue;
				}
				long tmp = arr[j]%n;
				int count = map.getOrDefault(tmp, 0);
				result+=count;
				if (tmp == 0) {
					result+=1;
				}

				map.put(tmp, count + 1);
			}
			sb.append(result).append("\n");
			map.clear();
		}
		System.out.println(sb);

	}

}