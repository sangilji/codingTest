import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int INF = 2_000_000_000;
	static int n;
	static int m;
	static int k;
	static int x;
	static int y;

	static int[] arr;
	static List<Integer> list = new ArrayList<>();
	static List<int[]>[] graph;
	static int[] parent;
	static int[] visit;
	static int[] sz;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		graph = new List[n + 1];
		visit = new int[n + 1];
		sz = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}

		dfs(1);
		int max = 0;
		int index = 0;
		for (int i = 1; i <= n; i++) {
			if (max < sz[i]) {
				index = i;
				max = sz[i];
			}
		}
		Arrays.fill(visit, 0);
		Arrays.fill(sz, 0);
		dfs(index);
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, sz[i]);
		}
		System.out.println(max);

	}

	private static void dfs(int cur) {
		visit[cur] = 1;
		for (int i = 0; i < graph[cur].size(); i++) {
			if (visit[graph[cur].get(i)[0]] == 1) {
				continue;
			}
			sz[graph[cur].get(i)[0]] = graph[cur].get(i)[1] +sz[cur];
			dfs(graph[cur].get(i)[0]);

		}
	}

}