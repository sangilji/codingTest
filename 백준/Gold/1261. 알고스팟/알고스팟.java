import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static long MOD = 1L << 32;
	static int n;
	static int m;
	static int k;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(tmp[j-1]);
			}
		}
		bfs();

	}
	private static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] == o2[2]) {
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o2[0] - o1[0];
			}
			return o1[2] - o2[2];
		});
		boolean[][] visit = new boolean[n + 1][m + 1];
		q.add(new int[] {1, 1, 0});
		visit[1][1] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == n && tmp[1] == m) {
				System.out.println(tmp[2]);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int x = tmp[0] + dx[i];
				int y = tmp[1] + dy[i];
				if (x <= 0 || y <= 0 || x > n || y > m || visit[x][y]) {
					continue;
				}
				visit[x][y]=true;
				if (arr[x][y] == 1) {
					q.add(new int[] {x, y, tmp[2] + 1});
				}else{
					q.add(new int[] {x, y, tmp[2]});
				}
			}
		}

	}

}