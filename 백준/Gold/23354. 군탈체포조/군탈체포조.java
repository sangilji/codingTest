import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static long MOD = 6000000000L;
	static int n;
	static int m;
	static int k;
	static int[][] arr;
	static long[][] dp;
	static long[][] map;
	static int[][] tmpArr;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int result = 0;
	static int startX;
	static int startY;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		startX = 0;
		startY = 0;
		result = 0;
		tmpArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == -1) {
					startX = i;
					startY = j;
				}
				if (arr[i][j] == 0) {
					list.add(new int[] {i, j});
				}
			}
		}
		arr[startX][startY] = 0;
		list.add(0, new int[] {startX, startY});
		if (list.size() == 1) {
			System.out.println(0);
			return;
		}
		map = new long[list.size()][list.size()];
		for (int i = 0; i < list.size(); i++) {
			Arrays.fill(map[i], MOD);
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				int tmp = dijk(list.get(i), list.get(j));
				if (map[i][j] > tmp) {
					map[i][j] = map[j][i] = tmp;
				}
			}
		}


		dp = new long[list.size()][1 << list.size()];
		for (int i = 0; i < list.size(); i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(dfs(0, 1));

	}

	private static long dfs(int current, int bit) {
		if (bit == (1 << list.size()) - 1) {
			return map[current][0];
		}

		if (dp[current][bit] != -1) {
			return dp[current][bit];
		}
		dp[current][bit] = MOD;

		for (int i = 0; i < list.size(); i++) {
			if (current != i) {
				dp[current][bit] = Math.min(dp[current][bit], dfs(i, bit | (1 << i)) + map[current][i]);
			}
			
		}
		return dp[current][bit];
	}

	private static int dijk(int[] a, int[] b) {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		q.add(new int[] {a[0], a[1], 0});
		boolean[][] visit = new boolean[n][n];
		visit[a[0]][a[1]] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == b[0] && tmp[1] == b[1]) {
				return tmp[2];
			}
			for (int i = 0; i < 4; i++) {
				int x = dx[i] + tmp[0];
				int y = dy[i] + tmp[1];
				if (x < 0 || y < 0 || x >= n || y >= n || visit[x][y]) {
					continue;
				}
				visit[x][y] = true;
				q.add(new int[] {x, y, tmp[2] + arr[x][y]});
			}
		}
		return 0;
	}

	static int allSum = Integer.MAX_VALUE;

}