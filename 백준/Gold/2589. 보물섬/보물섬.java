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
	static int n;
	static int m;
	static int k;

	static char[][] arr;
	static int[][] visit;
	static List<Integer> list = new ArrayList<>();
	static List<Integer>[] graph;
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
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 'L') {
					result = Math.max(result, bfs(i, j));
				}
			}
		}
		System.out.println(result);

	}

	private static int bfs(int x, int y) {

		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		int[][] visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visit[i], 1231231);
		}
		visit[x][y] = 0;
		q.add(new int[] {x, y, 0});
		int max = 0;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int tx = tmp[0] + dx[i];
				int ty = tmp[1] + dy[i];
				if (tx < 0 || ty < 0 || tx >= n || ty >= m || arr[tx][ty]=='W') {
					continue;
				}
				if (visit[tx][ty] > tmp[2] + 1) {
					visit[tx][ty] = tmp[2] + 1;
					q.add(new int[] {tx, ty, tmp[2] + 1});
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j] != 1231231) {
					max = Math.max(max, visit[i][j]);
				}
			}
		}
		return max;
	}

	static int result = 0;

}