import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 100_000;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		Set<Character>[] s = new Set[51];
		for (int i = 0; i < 51; i++) {
			s[i] = new HashSet<>();
		}

		for (int i = 0; i < t; i++) {
			String tmp = br.readLine();
			n = tmp.length();
			for (int j = 0; j < tmp.length(); j++) {
				s[j].add(tmp.charAt(j));
			}
		}
		for (int i = 0; i < n; i++) {
			if (s[i].size() == 1) {
				sb.append(s[i].stream().findFirst().get());
			} else {
				sb.append("?");
			}
		}
		System.out.println(sb);
	}

}