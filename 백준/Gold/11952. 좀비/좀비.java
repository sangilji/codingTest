import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static long INF = Long.MAX_VALUE;
	static int n;
	static int m;
	static int k;
	static int s;

	static int[][] arr;
	static int[][] visit;
	static List<Integer> list = new ArrayList<>();
	static List<Integer>[] graph;
	static int[] alpha;
	static int[] dx = {0, 0, 0, 1, -1};
	static int[] dy = {0, 1, -1, 0, 0};
	static Set<Integer> set = new HashSet<>();
	static int[] dist;
	static int[] depth;
	static int q;
	static int p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		graph = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		depth = new int[n + 1];
		dist = new int[n + 1];
		for (int i = 0; i < k; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		Arrays.fill(dist, p);
		bfs2();
		bfs();

	}

	private static void bfs2() {
		PriorityQueue<int[]> qu = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
		for (Integer integer : set) {
			qu.add(new int[] {integer, 0});
		}

		while (!qu.isEmpty()) {
			int[] tmp = qu.poll();

			if (tmp[1] == s) {
				return;
			}
			for (int i = 0; i < graph[tmp[0]].size(); i++) {
				int next = graph[tmp[0]].get(i);
				if (dist[next] == q) {
					continue;
				}
				dist[next] = q;
				qu.add(new int[] {next, tmp[1] + 1});
			}

		}
	}

	private static void bfs() {
		PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
		long[] visit = new long[n + 1];
		Arrays.fill(visit, INF);
		visit[1] = 0;
		q.add(new long[] {1, 0});
		while (!q.isEmpty()) {
			long[] tmp = q.poll();
			if (tmp[0] == n) {
				System.out.println(tmp[1] -dist[n]);
				return;
			}
			if (tmp[1] != visit[(int)tmp[0]]) {
				continue;
			}
			for (int i = 0; i < graph[(int)tmp[0]].size(); i++) {
				int next = graph[(int)tmp[0]].get(i);
				if (set.contains(next)) {
					continue;
				}
				if (visit[next] > tmp[1] + dist[next]) {
					visit[next] = tmp[1] + dist[next];
					q.add(new long[] {next, visit[next]});
				}
			}
		}
	}

}