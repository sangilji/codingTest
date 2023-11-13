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
	static List<Integer>[] graph;
	static int[] alpha;
	static int[] dx = {0, 0, 0, 1, -1};
	static int[] dy = {0, 1, -1, 0, 0};

	static int count = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		graph = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		bfs();

	}

	private static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		q.add(new int[] {1, 0});

		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int i = 0; i < graph[tmp[0]].size(); i++) {
				int next = graph[tmp[0]].get(i);

				if (dist[next] > tmp[1] + 1) {
					dist[next] = tmp[1] + 1;
					q.add(new int[] {next, dist[next]});
				}
			}
		}
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (dist[i] <= 2) {
				count++;
			}
		}
		System.out.println(count);
	}

}