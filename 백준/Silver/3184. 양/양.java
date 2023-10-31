import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int u;
	static int d;
	static int[][] dp;

	static char[][] arr;
	static int[][] visit;
	static int[] tree;
	static int sheep;
	static int wolf;
	static List<Integer>[] graph;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][];
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j] == 1 || arr[i][j] == '#') {
					continue;
				}
				bfs(i, j);
			}
		}
		System.out.println(sheep + " " + wolf);

	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	private static void bfs(int x, int y) {
		visit[x][y] = 1;
		Queue<int[]> q = new ArrayDeque<>();
		int o = 0;
		int v = 0;
		if (arr[x][y] == 'o') {
			o++;
		} else if (arr[x][y] == 'v') {
			v++;
		}
		q.add(new int[] {x, y});
		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int tx = tmp[0] + dx[i];
				int ty = tmp[1] + dy[i];
				if (tx < 0 || ty < 0 || tx >= n || ty >= m || arr[tx][ty] == '#' || visit[tx][ty] == 1) {
					continue;
				}
				visit[tx][ty] = 1;
				if (arr[tx][ty] == 'o') {
					o++;
				} else if (arr[tx][ty] == 'v') {
					v++;
				}
				q.add(new int[] {tx, ty});
			}
		}
		if (o > v) {
			v=0;
		}else{
			o=0;
		}
		wolf+=v;
		sheep+=o;
	}

}