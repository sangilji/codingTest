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
	static long n;
	static int m;
	static List<Integer> list = new ArrayList<>();
	static Map<Long, Long> map = new HashMap<>();
	static int[][] arr = new int[1001][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Long.parseLong(st.nextToken());
			long k = Long.parseLong(st.nextToken());
			long tmp =k;
			for (long j = 2; j <= Math.sqrt(k); j++) {
				while (tmp % j == 0) {
					map.put(j, map.getOrDefault(j, 0L) + 1L);
					tmp /= j;
				}
			}
			if (tmp != 1) {
				map.put(tmp, map.getOrDefault(tmp, 0L) + 1L);
			}
			long max = Long.MAX_VALUE;
			for (Map.Entry<Long, Long> entry : map.entrySet()) {
				long count = 0;
				Long key = entry.getKey();
				tmp = n;
				while (tmp!=0) {
					count+=tmp/key;
					tmp/=key;
				}
				max = Math.min(max,count/entry.getValue());
			}

			sb.append(max).append("\n");
			map.clear();

		}
		System.out.println(sb);
		

	}

}