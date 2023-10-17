import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int k;
	static int m;

	static int[][] arr;
	static int[][] visit;
	static boolean[][] visit2;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}

		recur(0, 0, 1);
		System.out.println(max);
	}

	static int max = 0;

	private static void recur(int x, int y, int current) {
		if (y >= m) {
			x+=1;
			y=0;
		}
		if (x >= n) {
			if (n>=2 && m>=2&&visit[n - 1][m - 1] == visit[n - 2][m - 2]) {
				return;
			}
			int result = 0;
			visit2 = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visit2[i][j]) {
						continue;
					}
					visit2[i][j] = true;
					int tmp = arr[i][j];
					for (int l = i + 1; l < n; l++) {
						if (visit[i][j] != visit[l][j]) {
							break;
						}
						visit2[l][j] =true;
						tmp = tmp*10 + arr[l][j];
					}
					for (int l = j + 1; l < m; l++) {
						if (visit[i][j] != visit[i][l]) {
							break;
						}
						visit2[i][l] =true;
						tmp = tmp*10 + arr[i][l];
					}
					result+=tmp;
				}
			}



			max = Math.max(result, max);
			return;
		}

		if (y - 1 >= 0) {
			if (x - 1 >= 0 && visit[x][y - 1] == visit[x - 1][y - 1]) {

			}else {
				visit[x][y] = visit[x][y - 1];
				recur(x, y + 1, current);
			}
		}
		if (x - 1 >= 0) {
			if (y - 1 >= 0 && visit[x - 1][y] == visit[x - 1][y - 1]) {

			} else if (y + 1 < m && visit[x - 1][y] == visit[x - 1][y + 1]) {

			}else{
				visit[x][y] = visit[x - 1][y];
				recur(x, y + 1, current);
			}
		}
		visit[x][y] = current;
		recur(x, y + 1, current + 1);

	}


	private static boolean check() {
		return false;
	}

}