import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int count = 50;
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
		arr = new int[7][7];
		for (int i = 0; i < 7; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 7; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < 7; i++) {
			if (arr[0][i] == 0) {
				start(i);
			}
		}
		System.out.println(count);
	}

	private static void start(int current) {
		int[][] newArr = new int[7][7];
		for (int i = 0; i < 7; i++) {
			System.arraycopy(arr[i], 0, newArr[i], 0, 7);
		}
		newArr[0][current] = n;
		drop(newArr);

		while (true) {
			boolean[][] visit = new boolean[7][7];
			boolean[][] check = check(visit, newArr);
			boolean delete = delete(newArr, check);
			if (!delete) {
				break;
			}
			drop(newArr);
		}

		result(newArr);

	}

	private static void result(int[][] newArr) {
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (newArr[i][j] != 0) {
					sum++;
				}
			}
		}
		count = Math.min(count, sum);
	}

	private static boolean delete(int[][] newArr, boolean[][] check) {
		boolean isDelete = false;

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (check[i][j]) {
					newArr[i][j] = 0;
					isDelete = true;
				}
			}
		}
		return isDelete;
	}

	private static boolean[][] check(boolean[][] visit, int[][] arr) {
		int[][] newArr = new int[7][7];
		boolean[][] returnArr = new boolean[7][7];
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (arr[i][j] == 0 || visit[i][j]) {
					continue;
				}
				visit[i][j] = true;

				newArr[i][j] = dfs(i, j + 1, arr, newArr, 1, visit);
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (arr[i][j] != 0 && arr[i][j] == newArr[i][j]) {
					returnArr[i][j] = true;
				}
			}
		}

		newArr = new int[7][7];
		visit = new boolean[7][7];

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (arr[j][i] == 0 || visit[j][i]) {
					continue;
				}
				newArr[j][i] = dfs2(j + 1, i, arr, newArr, 1, visit);
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (arr[i][j] != 0 && arr[i][j] == newArr[i][j]) {
					returnArr[i][j] = true;
				}
			}
		}
		return returnArr;
	}

	private static int dfs2(int x, int y, int[][] arr, int[][] newArr, int current, boolean[][] visit) {
		if (x >= 7 || arr[x][y] == 0) {
			return current;
		}
		visit[x][y] = true;
		return newArr[x][y] = dfs2(x + 1, y, arr, newArr, current + 1, visit);
	}

	private static int dfs(int x, int y, int[][] arr, int[][] newArr, int current, boolean[][] visit) {
		if (y >= 7 || arr[x][y] == 0) {
			return current;
		}
		visit[x][y] = true;
		return newArr[x][y] = dfs(x, y + 1, arr, newArr, current + 1, visit);
	}

	private static void drop(int[][] arr) {
		for (int i = 0; i < 7; i++) {
			int start = 6;
			for (int j = 6; j >= 0; j--) {
				if (arr[j][i] != 0) {
					arr[start][i] = arr[j][i];
					if (start != j) {
						arr[j][i] = 0;
					}
					start--;
				}
			}
		}
	}

}