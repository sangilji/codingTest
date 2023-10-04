import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static long MOD = 1L << 32;
	static int n;
	static int m;
	static int[][] arr;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	static int[] moveDx = {0, 1, 0, -1};
	static int[] moveDy = {-1, 0, 1, 0};

	static int result = 0;
	static int x;
	static int y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		x = n / 2 + 1;
		y = n / 2 + 1;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			broke(d, s);
			move();
			while (find()) {
				move();
			}
			change();

		}
		System.out.println(result);

	}

	private static void change() {
		Queue<Integer> q = new ArrayDeque<>();
		Stack<int[]> s = new Stack<>();
		int tx = x;
		int ty = y - 1;
		int count = 1;
		int increment = 1;
		int d = 1;
		while (tx >= 1 && ty >= 1) {
			if (increment != 0 && increment % 2 == 0) {
				count++;
			}
			increment++;
			for (int i = 0; i < count; i++) {
				if (tx < 1 || ty < 1) {
					break;
				}
				if (arr[tx][ty] == 0) {
					tx += moveDx[d];
					ty += moveDy[d];
					continue;
				}
				if (s.isEmpty()) {
					s.push(new int[] {tx, ty});
				} else {
					int[] tmp = s.peek();
					if (arr[tx][ty] == arr[tmp[0]][tmp[1]]) {
						s.push(new int[] {tx, ty});
					} else {
						q.add(s.size());
						q.add(arr[tmp[0]][tmp[1]]);
						s.clear();
						s.push(new int[] {tx, ty});
					}
				}
				tx += moveDx[d];
				ty += moveDy[d];
			}
			d = (d + 1) % 4;
		}
		if (!s.isEmpty()) {
			int[] peek = s.peek();
			q.add(s.size());
			q.add(arr[peek[0]][peek[1]]);
		}
		tx = x;
		ty = y - 1;
		count = 1;
		increment = 1;
		d = 1;
		while (tx >= 1 && ty >= 1) {
			if (increment != 0 && increment % 2 == 0) {
				count++;
			}
			increment++;
			for (int i = 0; i < count; i++) {
				if (tx < 1 || ty < 1) {
					break;
				}
				if (q.isEmpty()) {
					arr[tx][ty] = 0;
				} else {
					arr[tx][ty] = q.poll();
				}
				tx += moveDx[d];
				ty += moveDy[d];
			}
			d = (d + 1) % 4;
		}
	}

	private static boolean find() {
		Stack<int[]> s = new Stack<>();
		int tx = x;
		int ty = y - 1;
		int count = 1;
		int increment = 1;
		int d = 1;

		while (tx >= 1 && ty >= 1) {
			if (increment != 0 && increment % 2 == 0) {
				count++;
			}
			increment++;
			for (int i = 0; i < count; i++) {
				if (tx < 1 || ty < 1) {
					break;
				}
				if (arr[tx][ty] == 0) {
					tx += moveDx[d];
					ty += moveDy[d];
					continue;
				}
				if (s.isEmpty()) {
					s.push(new int[] {tx, ty, 1});
				} else {
					int[] tmp = s.peek();
					if (arr[tmp[0]][tmp[1]] == arr[tx][ty]) {
						s.push(new int[] {tx, ty, tmp[2] + 1});
					} else if (tmp[2] >= 4) {
						s.push(new int[] {tx, ty, 1});
					} else {
						int size = tmp[2];
						for (int j = 0; j < size; j++) {
							s.pop();
						}
						s.push(new int[] {tx, ty, 1});
					}
				}
				tx += moveDx[d];
				ty += moveDy[d];
			}
			d = (d + 1) % 4;
		}
		if (!s.isEmpty()) {
			int size = s.peek()[2];
			if (size < 4) {
				for (int i = 0; i < size; i++) {
					s.pop();
				}
			}
		}
		boolean b = false;
		while (!s.isEmpty()) {
			int[] tmp = s.pop();
			if (arr[tmp[0]][tmp[1]] == 1) {
				result += 1;
			} else if (arr[tmp[0]][tmp[1]] == 2) {
				result += 2;
			} else {
				result += 3;
			}
			arr[tmp[0]][tmp[1]] = 0;
			b = true;
		}
		return b;
	}

	private static void move() {
		Queue<int[]> q = new ArrayDeque<>();
		int tx = x;
		int ty = y - 1;
		int count = 1;
		int increment = 1;
		int d = 1;
		while (tx >= 1 && ty >= 1) {
			if (increment != 0 && increment % 2 == 0) {
				count++;
			}
			increment++;
			for (int i = 0; i < count; i++) {
				if (tx < 1 || ty < 1) {
					break;
				}
				int ttx = tx + moveDx[d];
				int tty = ty + moveDy[d];
				if (arr[tx][ty] == 0) {
					q.add(new int[] {tx, ty});

				} else if (!q.isEmpty()) {
					int[] tmp = q.poll();
					arr[tmp[0]][tmp[1]] = arr[tx][ty];
					arr[tx][ty] = 0;
					q.add(new int[] {tx, ty});
				}

				tx = ttx;
				ty = tty;
			}
			d = (d + 1) % 4;
		}
	}

	private static void broke(int d, int s) {
		int tx = x;
		int ty = y;
		for (int i = 0; i < s; i++) {
			tx += dx[d];
			ty += dy[d];
			if (tx <= 0 || ty <= 0 || ty > n || tx > n) {
				return;
			}
			arr[tx][ty] = 0;
		}
	}

}