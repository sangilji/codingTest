import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Map<String, Integer> m = new HashMap<>();
			int min = 1000000;
			for (int j = 0; j < n; j++) {
				String tmp = st.nextToken();
				m.put(tmp, m.getOrDefault(tmp, 0) + 1);
				if (m.get(tmp) >= 3) {
					min = 0;
				}
			}
			if (min == 0) {
				sb.append(0).append("\n");
				continue;
			}
			List<String> arr = new ArrayList<>();
			for (Map.Entry<String, Integer> e : m.entrySet()) {
				if (e.getValue() > 1) {
					arr.add(e.getKey());
					arr.add(e.getKey());
				} else {
					arr.add(e.getKey());
				}
			}

			for (int j = 0; j < arr.size(); j++) {
				for (int k = j + 1; k < arr.size(); k++) {
					for (int l = k + 1; l < arr.size(); l++) {
						int count = check(arr.get(j), arr.get(k), arr.get(l));
						min = Math.min(count, min);
					}
				}
			}
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static int check(String a, String b, String c) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
			if (a.charAt(i) != c.charAt(i)) {
				count++;
			}
			if (c.charAt(i) != b.charAt(i)) {
				count++;
			}
		}
		return count;
	}

}