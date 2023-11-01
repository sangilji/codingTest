import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[][] dp;

	static int[][] arr;
	static int[][] visit;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new int[n][m];
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
				if (arr[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}
		bfs(x, y);

	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	private static void bfs(int x, int y) {
		visit[x][y] = 1;
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

		q.add(new int[] {x, y, 0});
		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			if (arr[tmp[0]][tmp[1]] > 2) {
				System.out.println("TAK");
				System.out.println(tmp[2]);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int tx = tmp[0] + dx[i];
				int ty = tmp[1] + dy[i];
				if (tx < 0 || ty < 0 || tx >= n || ty >= m || arr[tx][ty] == 1 || visit[tx][ty]==1) {
					continue;
				}
				visit[tx][ty] = 1;
				q.add(new int[] {tx, ty, tmp[2] + 1});
			}
		}
		System.out.println("NIE");

	}

}