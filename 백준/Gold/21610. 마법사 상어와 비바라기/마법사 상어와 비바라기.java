import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int count = 0;
	static int n;
	static int m;
	static int s;
	static int[][] arr;
	static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q.add(new int[] {n - 1, 0});
		q.add(new int[] {n - 2, 0});
		q.add(new int[] {n - 1, 1});
		q.add(new int[] {n - 2, 1});

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			move(d, s);
			plus();
			copy();
			makeCloud();
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				count += arr[i][j];
			}
		}
		System.out.println(count);
	}

	private static void makeCloud() {
		int[][] tmp = new int[n][n];
		for (int[] ints : q) {
			tmp[ints[0]][ints[1]] += 1;
		}
		q.clear();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tmp[i][j] == 0 && arr[i][j] >= 2) {
					q.add(new int[] {i, j});
					arr[i][j] -= 2;
				}
			}
		}
	}

	private static void plus() {
		for (int[] tmp : q) {
			arr[tmp[0]][tmp[1]] += 1;
		}
	}

	private static void copy() {
		int[][] copy = new int[n][n];
		for (int[] tmp : q) {
			for (int i = 2; i <= 8; i += 2) {
				int x = dx[i] + tmp[0];
				int y = dy[i] + tmp[1];
				if (x < 0 || y < 0 || x >= n || y >= n || arr[x][y] == 0) {
					continue;
				}
				copy[tmp[0]][tmp[1]] += 1;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] += copy[i][j];
			}
		}
	}

	private static void move(int d, int s) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int[] tmp = q.poll();
			tmp[0] = (tmp[0] + dx[d] * s + s * n) % n;
			tmp[1] = (tmp[1] + dy[d] * s + s * n) % n;
			q.add(tmp);
		}
	}

}