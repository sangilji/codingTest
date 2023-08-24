import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		bfs();

	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][m];
		findI(q, visit);
		int count = 0;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (arr[tmp[0]][tmp[1]] == 'P') {
				count++;
			}
			for (int i = 0; i < 4; i++) {
				int x = dx[i] + tmp[0];
				int y = dy[i] + tmp[1];
				if (x < 0 || y < 0 || x >= n || y >= m || arr[x][y] == 'X' || visit[x][y]) {
					continue;
				}
				visit[x][y] = true;
				q.add(new int[] {x, y});
			}
		}
		if (count == 0) {
			System.out.println("TT");
			return;
		}
		System.out.println(count);
	}

	private static void findI(Queue<int[]> q, boolean[][] visit) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 'I') {
					q.add(new int[] {i, j});
					visit[i][j] = true;
					return;
				}
			}
		}
	}

}