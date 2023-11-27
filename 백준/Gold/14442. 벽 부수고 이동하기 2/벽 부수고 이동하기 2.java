import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int k;
	static int x;
	static int y;

	static int[][] arr;
	static List<Integer>[] list;
	static List<Integer>[] graph;

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		bfs();
	}

	private static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		q.add(new int[] {0, 0, 1, 0});
		boolean[][][] visit = new boolean[n][m][k+1];
		visit[0][0][0] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == n - 1 && tmp[1] == m - 1) {
				System.out.println(tmp[2]);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int tx = tmp[0] + dx[i];
				int ty = tmp[1] + dy[i];
				if (tx < 0 || ty < 0 || tx >= n || ty >= m || visit[tx][ty][tmp[3]]) {
					continue;
				}
				if (arr[tx][ty] == 1 && tmp[3]<k && !visit[tx][ty][tmp[3]+1]) {
					visit[tx][ty][tmp[3]+1] = true;
					q.add(new int[]{tx,ty,tmp[2]+1,tmp[3]+1});
				}
				if (arr[tx][ty] == 0) {
					visit[tx][ty][tmp[3]] = true;
					q.add(new int[] {tx, ty, tmp[2] + 1, tmp[3]});
				}
			}
		}
		System.out.println(-1);

	}

}