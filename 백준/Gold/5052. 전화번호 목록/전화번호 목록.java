import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static String[] arr;
	static int[] tree;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			Set<String> set = new HashSet<>();
			arr = new String[n];

			for (int j = 0; j < n; j++) {
				arr[j] = br.readLine();
				set.add(arr[j]);
			}
			if (find(set)) {
				sb.append("YES\n");
				continue;
			}
			sb.append("NO\n");
		}
		System.out.println(sb);
	}

	private static boolean find(Set<String> set) {
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < arr[i].length(); j++) {
				if (set.contains(arr[i].substring(0, j))) {
					return false;
				}
			}
		}
		return true;
	}

}