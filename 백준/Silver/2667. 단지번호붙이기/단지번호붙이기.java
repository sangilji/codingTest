import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int k;
	static int[][] dp;

	static int[][] arr;
	static List<Integer>[] list;
	static int[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		visit = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		PriorityQueue<Integer> q = new PriorityQueue<>(Integer::compareTo);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == 0 && arr[i][j] == 1) {
					q.add(dfs(i, j));
					count++;
				}
			}
		}
		sb.append(count).append("\n");
		while (!q.isEmpty()) {
			sb.append(q.poll()).append("\n");
		}
		System.out.println(sb);
	}

	private static int dfs(int x,int y) {
		visit[x][y] = 1;
		int tmp = 1;
		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if (tx < 0 || ty < 0 || tx >= n || ty >= n || visit[tx][ty] == 1 || arr[tx][ty] == 0) {
				continue;
			}
			tmp += dfs(tx, ty);
		}
		return tmp;
	}

}