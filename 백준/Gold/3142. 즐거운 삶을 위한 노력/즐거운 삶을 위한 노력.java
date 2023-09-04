import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static int MOD = 1_000_000;
	static long n;
	static int m;
	static List<Integer> list = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < n; i++) {
			int tmp = m = Integer.parseInt(br.readLine());
			if (m == 1) {
				if (count >= 1) {
					sb.append("NE").append("\n");
				}else{
					sb.append("DA").append("\n");
				}
				continue;
			}
			for (int k : list) {
				if (k > Math.sqrt(m)) {
					break;
				}
				while (tmp % k == 0) {
					map.put(k, map.getOrDefault(k, 0) + 1);
					if (map.get(k) % 2 == 1) {
						count++;
					} else {
						count--;
					}
					tmp /= k;
				}
			}
			if (tmp != 1) {
				map.put(tmp, map.getOrDefault(tmp, 0) + 1);
				if (map.get(tmp) % 2 == 1) {
					count++;
				}else{
					count--;
				}
			}

			if (count >= 1) {
				sb.append("NE").append("\n");
			}else{
				sb.append("DA").append("\n");
			}
		}
		System.out.println(sb);


		// StringTokenizer st = new StringTokenizer(br.readLine());


		

	}

	private static void init() {
		arr = new int[1000100];
		for (int i = 2; i <= Math.sqrt(1000000) ; i++) {
			if (arr[i] == 1) {
				continue;
			}
			list.add(i);
			for (int j = i + i; j <= 1000000; j += i) {
				arr[j] = 1;
			}
		}
	}

}