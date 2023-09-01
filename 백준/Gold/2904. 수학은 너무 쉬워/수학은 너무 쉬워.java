import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000;
	static long n;
	static int m;
	static Map<Integer, Integer>[] list;
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		list = new Map[n];
		for (int i = 0; i < n; i++) {
			list[i] = new HashMap<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int tmp = arr[i];
			for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
				while (tmp % j == 0) {
					list[i].put(j, list[i].getOrDefault(j, 0) + 1);
					tmp /= j;
					map.put(j, map.getOrDefault(j, 0) + 1);
				}
			}
			if (tmp != 1) {
				list[i].put(tmp, list[i].getOrDefault(tmp, 0) + 1);
				map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			}
		}
		long result = 1;
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if (value >= n) {
				int tmp = value / n;
				result *= (long)Math.pow(key, tmp);
				for (int i = 0; i < n; i++) {
					int j = list[i].getOrDefault(key, 0);
					if (j < tmp) {
						count += tmp - j;
					}
				}
			}
		}
		sb.append(result).append(" ").append(count);
		System.out.println(sb);

	}

}