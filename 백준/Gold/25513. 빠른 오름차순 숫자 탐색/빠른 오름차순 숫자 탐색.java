import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int k;

	static int[][] arr;
	static int[][] visit;
	static List<Integer> list = new ArrayList<>();
	static List<Integer>[] graph;
	static int[] alpha;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};

	static int count = 0;
	static Set<Integer> s = new HashSet<>();
	static int x;
	static int y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = 5;
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= 6; i++) {
			if (!bfs(i)) {
				System.out.println(-1);
				return;
			}

		}
		System.out.println(result);
	}

	static int result = 0;

	private static boolean bfs(int count) {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		int[][] visit = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visit[i], 123123);
		}
		q.add(new int[] {x, y, 0});
		visit[x][y] = 0;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (arr[tmp[0]][tmp[1]] == count) {
				result += tmp[2];
				x = tmp[0];
				y = tmp[1];
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int tx = tmp[0] + dx[i];
				int ty = tmp[1] + dy[i];
				if (tx < 0 || ty < 0 || tx >= n || ty >= n || arr[tx][ty] == -1) {
					continue;
				}
				if (visit[tx][ty] > tmp[2] + 1) {
					visit[tx][ty] = tmp[2] + 1;
					q.add(new int[] {tx, ty, tmp[2] + 1});
				}
			}
		}
		return false;
	}

}