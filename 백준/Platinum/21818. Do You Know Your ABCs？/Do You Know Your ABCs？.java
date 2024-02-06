import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] arr;
	static int[] abc = new int[3];
	static List<Integer> list = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			count = 0;
			list.clear();
			map.clear();
			s.clear();
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				list.add(arr[j]);
				map.put(arr[j], 1);
			}
			Arrays.sort(arr);
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int tmp = arr[k] - arr[j];
					if (map.getOrDefault(tmp, 0) >= 2) {
						continue;
					}
					list.add(tmp);
					map.put(tmp, map.getOrDefault(tmp, 0) + 1);
				}
			}
			list.sort(Integer::compareTo);
			dfs(0, 0);
			sb.append(count).append("\n");

		}
		System.out.println(sb);
	}

	static int count = 0;
	static Set<String> s = new HashSet<>();
	private static void dfs(int depth, int current) {
		if (depth == 3) {
			String tmp = "" + abc[0] + abc[1] + abc[2];
			if (s.contains(tmp)) {
				return;
			}
			s.add(tmp);
			if (check()){
				count++;
			}
			return;
		}

		for (int i = current; i < list.size(); i++) {
			abc[depth] = list.get(i);
			dfs(depth + 1, i + 1);
		}

	}

	private static boolean check() {
		for (int i = 0; i < n; i++) {
			if (!checkOne(arr[i])) {
				return false;
			}
		}
		return true;

	}

	private static boolean checkOne(int i) {
		return i == abc[0] || i == abc[1] || i == abc[2] || i == abc[0] + abc[1] || i == abc[0] + abc[2]
			|| i == abc[1] + abc[2] || i == abc[0] + abc[1] + abc[2];
	}

}