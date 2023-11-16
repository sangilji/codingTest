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
	static int INF = 2_000_000_000;
	static int n;
	static int m;
	static int x;
	static int y;

	static int[][] arr;
	static int[][] visit;
	static List<Integer> list = new ArrayList<>();
	static List<Integer>[] graph;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];
		st = new StringTokenizer(br.readLine());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs(startX, startY));

	}

	private static int bfs(int startX, int startY) {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		int[][][] dist = new int[n + 1][m + 1][3];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				Arrays.fill(dist[i][j], INF);
			}
		}
		dist[startX][startY][0] = 0;
		q.add(new int[] {startX, startY, 0, 1});

		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			if (tmp[0] == x && tmp[1] == y) {
				return tmp[2];
			}

			if (tmp[3] % 3 == 0) {
				add(0, 4, tmp, dist, q);
			} else if (tmp[3] % 3 == 2) {
				add(0, 2, tmp, dist, q);
			} else {
				add(2, 4, tmp, dist, q);
			}
		}

		return -1;
	}

	private static void add(int start, int x, int[] tmp, int[][][] dist, PriorityQueue<int[]> q) {
		for (int i = start; i < x; i++) {
			int tx = tmp[0] + dx[i];
			int ty = tmp[1] + dy[i];
			if (tx <= 0 || ty <= 0 || tx > n || ty > m || arr[tx][ty] == -1) {
				continue;
			}
			if (dist[tx][ty][tmp[3] % 3] > tmp[2] + arr[tx][ty]) {
				dist[tx][ty][tmp[3] % 3] = tmp[2] + arr[tx][ty];
				q.add(new int[] {tx, ty, dist[tx][ty][tmp[3] % 3], tmp[3] + 1});
			}
		}
	}

}