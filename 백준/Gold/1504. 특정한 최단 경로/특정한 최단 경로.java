import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int INF = 1_500_000_000;
	static int n;
	static int m;
	static int k;

	static int[][] arr;
	static int[][] visit;
	static List<Integer> list = new ArrayList<>();
	static List<int[]>[] graph;
	static int[] alpha;
	static int[] dx = {0, 0, 0, 1, -1};
	static int[] dy = {0, 1, -1, 0, 0};

	static int count = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] tmp = bfs(a,b);
		int[] tmp2 = bfs(b, a);
		if ((tmp[0] == INF || tmp[1] == INF || tmp2[2] == INF) || (tmp2[0] == INF || tmp2[1] == INF || tmp[2] == INF)) {
			System.out.println(-1);
			return;
		}
		System.out.println(Math.min(tmp[0] + tmp[1] + tmp2[2], tmp2[0] + tmp2[1] + tmp[2]));
	}

	private static int[] bfs(int cur, int b) {

		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[cur] = 0;
		q.add(new int[] {cur, 0});

		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int i = 0; i < graph[tmp[0]].size(); i++) {
				int[] next = graph[tmp[0]].get(i);

				if (dist[next[0]] > tmp[1] + next[1]) {
					dist[next[0]] = tmp[1] + next[1];
					q.add(new int[] {next[0], dist[next[0]]});
				}
			}
		}
		return new int[] {dist[1], dist[b], dist[n]};
	}

}