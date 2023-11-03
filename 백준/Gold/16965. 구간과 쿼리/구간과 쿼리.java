import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int k;

	static char[][] arr;
	static int[] visit;
	static List<int[]> list = new ArrayList<>();
	static List<Integer>[] graph;
	static int[] alpha;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		list.add(new int[] {0, 0});
		graph = new List[n + 1];
		visit = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				for (int j = 1; j < list.size(); j++) {
					if ((list.get(j)[0] < b && b < list.get(j)[1]) || (list.get(j)[0] < c
						&& c < list.get(j)[1])) {
						graph[list.size()].add(j);
					}
					if ((b < list.get(j)[0] && list.get(j)[0] < c) || (b < list.get(j)[1]
						&& list.get(j)[1] < c)) {
						graph[j].add(list.size());
					}
				}
				list.add(new int[] {b, c});
			} else {
				Arrays.fill(visit, 0);
				sb.append(dfs(b, c) ? 1 : 0).append("\n");
			}
		}
		System.out.println(sb);

	}

	private static boolean dfs(int b, int c) {
		visit[b] = 1;
		if (b == c) {
			return true;
		}
		boolean tmp = false;
		for (int i = 0; i < graph[b].size(); i++) {
			if (visit[graph[b].get(i)] == 1) {
				continue;
			}
			tmp |= dfs(graph[b].get(i), c);

		}
		return tmp;
	}

}