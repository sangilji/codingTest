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
	static int INF = 1_500_000_000;
	static int n;
	static int m;
	static int k;

	static int[][] arr;
	static int[][] visit;
	static List<Integer> list = new ArrayList<>();
	static List<int[]>[] graph;
	static int[] alpha;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};

	static int count = 0;
	static Set<Integer> s = new HashSet<>();
	static int x;
	static int y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		bfs();
	}

	private static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		int[][] visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visit[i], INF);
		}
		q.add(new int[] {0, 0, 0});
		visit[0][0] = 0;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int tx = tmp[0] + dx[i];
				int ty = tmp[1] + dy[i];
				if (tx < 0 || ty < 0 || tx >= n || ty >= m) {
					continue;
				}
				if (visit[tx][ty] > tmp[2] + arr[tx][ty]) {
					visit[tx][ty] = tmp[2] + arr[tx][ty];
					q.add(new int[] {tx, ty, tmp[2] + arr[tx][ty]});
				}
			}
		}

		System.out.println(visit[n - 1][m - 1]);
	}

	static int result = 0;

}