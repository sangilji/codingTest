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
	static int[] dx = {0, 0, 0, 1, -1};
	static int[] dy = {0, 1, -1, 0, 0};

	static int count = 0;
	static Set<Integer> s = new HashSet<>();
	static int x;
	static int y;
	static int d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		int startD = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		bfs(startX, startY, startD);
	}

	private static void bfs(int startX, int startY, int startD) {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[3]));
		int[][][] visit = new int[n + 1][m + 1][5];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				Arrays.fill(visit[i][j], INF);
			}
		}
		q.add(new int[] {startX, startY, startD, 0});
		visit[startX][startY][startD] = 0;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tx = tmp[0];
			int ty = tmp[1];
			if (tx == x && ty == y && tmp[2] == d) {
				System.out.println(tmp[3]);
				return;
			}
			for (int i = 1; i <= 3; i++) {
				tx += dx[tmp[2]];
				ty += dy[tmp[2]];
				if (tx <= 0 || ty <= 0 || tx > n || ty > m || arr[tx][ty] == 1) {
					break;
				}
				if (visit[tx][ty][tmp[2]] > tmp[3] + 1) {
					visit[tx][ty][tmp[2]] = tmp[3] + 1;
					q.add(new int[] {tx, ty, tmp[2], tmp[3] + 1});
				}
			}
			if (tmp[2] <= 2) {
				if (visit[tmp[0]][tmp[1]][3] > tmp[3] + 1) {
					visit[tmp[0]][tmp[1]][3] = tmp[3] + 1;
					q.add(new int[] {tmp[0], tmp[1], 3, tmp[3] + 1});
				}
				if (visit[tmp[0]][tmp[1]][4] > tmp[3] + 1) {
					visit[tmp[0]][tmp[1]][4] = tmp[3] + 1;
					q.add(new int[] {tmp[0], tmp[1], 4, tmp[3] + 1});
				}
			} else {
				if (visit[tmp[0]][tmp[1]][1] > tmp[3] + 1) {
					visit[tmp[0]][tmp[1]][1] = tmp[3] + 1;
					q.add(new int[] {tmp[0], tmp[1], 1, tmp[3] + 1});
				}
				if (visit[tmp[0]][tmp[1]][2] > tmp[3] + 1) {
					visit[tmp[0]][tmp[1]][2] = tmp[3] + 1;
					q.add(new int[] {tmp[0], tmp[1], 2, tmp[3] + 1});
				}
			}

		}
	}

	static int result = 0;

}