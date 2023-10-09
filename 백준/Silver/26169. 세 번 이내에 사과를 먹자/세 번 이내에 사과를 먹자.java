import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int k;
	static int x;
	static int y;

	static int count = 0;

	static int[][] arr;
	static boolean[][] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = 5;
		m = 5;
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		if (arr[x][y] == 1) {
			arr[x][y] = -1;
			dfs(x, y, 1, 0);
		} else {
			arr[x][y] = -1;
			dfs(x, y, 0, 0);
		}
		if (b) {
			System.out.println(1);
		}else{
			System.out.println(0);
		}
	}

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean b = false;

	private static void dfs(int x, int y, int count, int depth) {
		if (depth == 3) {
			if (count >= 2) {
				b = true;
				return;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int tx = dx[i] + x;
			int ty = dy[i] + y;
			if (tx < 0 || ty < 0 || tx >= n || ty >= m || arr[tx][ty] == -1) {
				continue;
			}

			if (arr[tx][ty] == 1) {
				arr[tx][ty] = -1;
				dfs(tx, ty, count + 1, depth + 1);
				arr[tx][ty] = 1;
			} else {
				arr[tx][ty] = -1;
				dfs(tx, ty, count, depth + 1);
				arr[tx][ty] = 0;
			}
		}

	}

}