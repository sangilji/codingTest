import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int k;
	static int[][] dp;

	static int[][] arr;
	static List<Integer>[] list;
	static int[] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static Set<Integer> set = new HashSet<>();

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		list = new List[n + 1];
		visit = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			list[i].add(tmp);
		}
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visit, 0);
			dfs(i, i);
		}
		sb.append(set.size()).append("\n");
		int[] array = set.stream().mapToInt(Integer::intValue).sorted().toArray();
		for (int i = 0; i < set.size(); i++) {
			sb.append(array[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean dfs(int cur, int start) {
		visit[cur] = 1;
		boolean tmp = false;
		for (int i = 0; i < list[cur].size(); i++) {
			if (visit[list[cur].get(i)] == 1) {
				if (list[cur].get(i) == start) {
					tmp = true;
				}
				continue;
			}
			tmp |= dfs(list[cur].get(i), start);
		}
		if (tmp) {
			set.add(cur);
		}
		return tmp;
	}

}