import java.util.*;
import java.io.*;
public class Main {
	private static int n;
	private static int m;
	private static int[][] map;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 1, 0});
		boolean[][] visit = new boolean[n][m];

		map[0][0] = 2;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == n - 1 && tmp[1] == m - 1) {
				return tmp[2];
			}
			for (int i = 0; i < 4; i++) {
				int x = tmp[0] + dx[i];
				int y = tmp[1] + dy[i];

				if (x < 0 || x >= n || y < 0 || y >= m) {
					continue;
				}
				if (tmp[3] == 1) {
					if (!visit[x][y]&&map[x][y] == 0) {
						visit[x][y]=true;
						q.add(new int[] {x, y, tmp[2] + 1, tmp[3]});
					}
				} else {
					if (map[x][y] == 0) {
						map[x][y] = 2;
						q.add(new int[] {x, y, tmp[2] + 1, tmp[3]});
					} else if (map[x][y] == 1) {
						map[x][y] = 2;
						q.add(new int[] {x, y, tmp[2] + 1, 1});
					}
				}
			}
		}
		return -1;
	}
}