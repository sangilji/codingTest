import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count = 50;
	static int n;
	static int m;
	static int x;
	static int t;
	static int d;
	static int k;
	static int[][] arr;

	static int[] dy = {1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			for (int j = x; j <= n; j += x) {
				move(j, d, k);
			}
			boolean b = sameNumber();
			if (!b) {
				float avg = avg();
				change(avg);
			}

		}
		result();
	}

	private static void result() {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] != 0) {
					sum += arr[i][j];
				}
			}
		}
		System.out.println(sum);
	}

	private static float avg() {
		int count = 0;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] != 0) {
					count++;
					sum += arr[i][j];
				}
			}
		}
		return sum * 1.0f / count;
	}

	private static void change(float avg) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] == 0) {
					continue;
				}
				if (arr[i][j] * 1.0f > avg) {
					arr[i][j] -= 1;
					continue;
				}
				if (arr[i][j] * 1.0f < avg) {
					arr[i][j] += 1;
				}
			}
		}
	}

	private static boolean sameNumber() {
		int count = 0;
		boolean[][] visit = new boolean[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] == 0) {
					continue;
				}
				int x1 = i + 1;
				int y1 = (j + 1) % m == 0 ? m : (j + 1) % m;
				if (i != n) {
					if (arr[i][j] == arr[x1][j]) {
						visit[i][j] = true;
						visit[x1][j] = true;
						count++;
					}
				}
				if (arr[i][j] == arr[i][y1]) {
					visit[i][j] = true;
					visit[i][y1] = true;
					count++;
				}
			}
		}
		if (count == 0) {
			return false;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (visit[i][j]) {
					arr[i][j] = 0;
				}
			}
		}
		return true;
	}

	private static void move(int x, int d, int k) {
		int[] tmp = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			int y = (i + dy[d] * k + m * k) % m;
			y = y == 0 ? m : y;
			tmp[y] = arr[x][i];
		}
		arr[x] = tmp;
	}

}