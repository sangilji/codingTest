import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count = 0;
	static int n;
	static int m;
	static int x;
	static int y;
	static int d;
	static int k;
	static int[][] arr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] gun;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		gun = new int[k];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			gun[i] = Integer.parseInt(st.nextToken());
		}
		int[][][] tmpArr = new int[n][n][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < 2; l++) {
					tmpArr[i][j][l] = arr[i][j];
				}
			}
		}
		dfs(0, tmpArr, 0);
		System.out.println(count);
	}

	private static void dfs(int depth, int[][][] tmpArr, int score) {
		if (depth == k) {
			count = Math.max(count, score);
			return;
		}
		int[][][] newArr = new int[n][n][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.arraycopy(tmpArr[i][j], 0, newArr[i][j], 0, 2);
			}
		}

		for (int i = 0; i < n; i++) {
			int plus = 0;
			for (int j = 0; j < n; j++) {
				if (tmpArr[i][j][0] > 0) {
					if (tmpArr[i][j][0] >= 10) {
						newArr[i][j][1] = 0;
						newArr[i][j][0] = 0;
						plus = tmpArr[i][j][1];
						dfs(depth + 1, newArr, score + plus);
						newArr[i][j][1] = tmpArr[i][j][0];
						newArr[i][j][0] = tmpArr[i][j][0];
					} else if (tmpArr[i][j][0] > gun[depth]) {
						newArr[i][j][0] -= gun[depth];
						dfs(depth + 1, newArr, score);
						newArr[i][j][0] += gun[depth];
					} else if (tmpArr[i][j][0] <= gun[depth]) {
						newArr[i][j][0] = 0;
						newArr[i][j][1] = 0;
						plus = tmpArr[i][j][1];
						make(newArr, i, j, tmpArr[i][j][1] / 4);
						dfs(depth + 1, newArr, score + plus);
						newArr[i][j][1] = tmpArr[i][j][1];
						newArr[i][j][0] = tmpArr[i][j][0];
						originalMake(newArr, i, j, tmpArr);
					}
					break;
				}
			}
		}
	}

	private static void originalMake(int[][][] newArr, int x, int y, int[][][] tmpArr) {
		for (int i = 0; i < 4; i++) {
			int tx = dx[i] + x;
			int ty = dy[i] + y;
			if (tx < 0 || ty < 0 || tx >= n || ty >= n) {
				continue;
			}
			newArr[tx][ty][0] = tmpArr[tx][ty][0];
			newArr[tx][ty][1] = tmpArr[tx][ty][1];
		}
	}

	private static void make(int[][][] newArr, int x, int y, int tmp) {
		if (tmp == 0) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int tx = dx[i] + x;
			int ty = dy[i] + y;
			if (tx < 0 || ty < 0 || tx >= n || ty >= n || newArr[tx][ty][0] > 0) {
				continue;
			}
			newArr[tx][ty][0] = tmp;
			newArr[tx][ty][1] = tmp;
		}
	}

}