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

	static char[][] arr;
	static int[] visit;
	static List<Integer> list = new ArrayList<>();
	static List<Integer>[] graph;
	static int[] alpha;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};

	static int count = 0;
	static Set<Integer> s = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		graph = new List[n + 1];
		visit = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= n; i++) {
			graph[i].add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i <= n; i++) {
			if (s.contains(i)) {
				continue;
			}
			Arrays.fill(visit, 0);
			list.add(dfs(i, i));
		}
		long a = list.get(0);
		for (int i = 1; i <list.size(); i++) {
			long tmp = gcd(a, list.get(i));
			a = a * (list.get(i) / tmp);
		}
		System.out.println(a);
	}

	private static long gcd(long a, long b) {
		if (a > b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		if (a == 0) {
			return b;
		}
		while (true) {
			if (b % a == 0) {
				return a;
			}
			b %= a;

			long tmp = a;
			a = b;
			b = tmp;
		}

	}

	private static int dfs(int cur, int start) {
		visit[cur] = 1;
		int tmp = 0;
		for (int i = 0; i < graph[cur].size(); i++) {
			if (visit[graph[cur].get(i)] == 1) {
				if (graph[cur].get(i) == start) {
					s.add(cur);
					return 1;
				}
				continue;
			}
			tmp = dfs(graph[cur].get(i), start);
			if (tmp > 0) {
				break;
			}
		}
		if (tmp != 0) {
			s.add(cur);
			tmp += 1;
		}
		return tmp;
	}

}