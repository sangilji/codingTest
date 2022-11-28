package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main14502 {
	private static int N;
	private static int M;
	private static int[][] map;
	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	static Queue<int[]> q = new LinkedList<>();
	static int max = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = s.nextInt();
			}
		}
		dfs(0);

		System.out.println(max);
	}

	private static void dfs(int depth) {
		if (depth == 3) {
			result();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					continue;
				}
				map[i][j] = 1;
				dfs(depth + 1);
				map[i][j] = 0;
			}
		}
	}

	private static void result() {
		int[][] virus_map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virus_map[i][j] = map[i][j];
				if (map[i][j] == 2) {
					q.add(new int[] {i, j});
				}
			}
		}

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = pos[0] + dx[i];
				int y = pos[1] + dy[i];
				if (x < 0 || y < 0 || x >= N || y >= M || virus_map[x][y] > 0) {
					continue;
				}
				virus_map[x][y] = 2;
				q.add(new int[] {x, y});
			}
		}
		maxValue(virus_map);
	}

	private static void maxValue(int[][] virus_map) {

		max = Math.max(max, Arrays.stream(virus_map)
			.mapToInt(n -> (int)Arrays.stream(n)
				.filter(m -> m == 0)
				.count())
			.sum());
	}
}
