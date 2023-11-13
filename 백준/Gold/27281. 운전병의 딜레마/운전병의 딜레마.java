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
	static long INF = 2_000_000_000_000_00L;
	static int n;
	static int m;
	static int k;

	static int[][] arr;
	static int[][] visit;
	static List<Integer> list = new ArrayList<>();
	static List<long[]>[] graph;
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
		k = Integer.parseInt(st.nextToken());

		graph = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		int last = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[a].add(new long[] {b, d, c});
			graph[b].add(new long[] {a, d, c});
		}
		int start = 0;
		last = 1_000_000_000;
		long result = INF;
		while (start <= last) {
			int mid = (start + last) / 2;
			if (bfs(mid)) {
				result = mid;
				last = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (result == INF) {
			System.out.println(-1);
			return;
		}
		System.out.println(result);
	}

	private static boolean bfs(int cur) {
		PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
		long[] dist = new long[n + 1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		q.add(new long[] {1, 0});

		while (!q.isEmpty()) {
			long[] tmp = q.poll();
			if (tmp[0] == n) {
				return tmp[1] <= k;
			}
			if (tmp[1] != dist[(int)tmp[0]]) {
				continue;
			}
			for (int i = 0; i < graph[(int)tmp[0]].size(); i++) {
				long[] next = graph[(int)tmp[0]].get(i);
				long t = 0;
				if (next[1] > cur) {
					t = next[1] - cur;
				}
				if (dist[(int)next[0]] > tmp[1] + next[2] + t) {
					dist[(int)next[0]] = tmp[1] + next[2] + t;
					q.add(new long[] {next[0], dist[(int)next[0]]});
				}
			}
		}
		return dist[n] <= k;
	}

}