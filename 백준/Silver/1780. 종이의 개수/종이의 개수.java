import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int a = 0;
	private static int b = 0;
	private static int c = 0;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, n);
		System.out.printf("%d\n%d\n%d",a,b,c);
	}

	private static void dfs(int x, int y, int n) {
		if (checkColor(x, y, n)) {
			if (map[x][y] == -1) {
				a++;
			} else if (map[x][y] == 0) {
				b++;
			} else {
				c++;
			}
			return;
		}
		int size = n / 3;
		dfs(x, y, size);
		dfs(x, y + size, size);
		dfs(x, y + 2 * size, size);

		dfs(x + size, y, size);
		dfs(x + size, y + size, size);
		dfs(x + size, y + 2 * size, size);

		dfs(x + 2 * size, y, size);
		dfs(x + 2 * size, y + size, size);
		dfs(x + 2 * size, y + 2 * size, size);
	}

	private static boolean checkColor(int x, int y, int n) {
		int color = map[x][y];
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if (color != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
