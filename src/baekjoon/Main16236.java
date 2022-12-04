package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main16236 {
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {-1, 1, 0, 0};
	private static boolean[][] visit;

	private static class Shark {
		int x;
		int y;
		int size;
		int move = 0;
		int eatingCount = 0;

		public Shark(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		public void eat(int fishX, int fishY, int move) {
			this.move += move;
			eatingCount++;
			x = fishX;
			y = fishY;
			if (eatingCount == size) {
				size++;
				eatingCount = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] map = new int[n][n];

		Shark shark = null;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = s.nextInt();
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2);
					map[i][j] = 0;
				}
			}
		}
		Shark finalShark = shark;
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] == o2[2]) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
			return o1[2] - o2[2];
		});

		while (true) {
			q.add(new int[] {finalShark.x, finalShark.y, 0});
			visit = new boolean[n][n];

			visit[finalShark.x][finalShark.y] = true;
			boolean b = true;
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				if (map[tmp[0]][tmp[1]] != 0 && finalShark.size > map[tmp[0]][tmp[1]]) {
					finalShark.eat(tmp[0], tmp[1], tmp[2]);
					map[tmp[0]][tmp[1]] = 0;
					q.clear();
					b = false;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int x = tmp[0] + dx[i];
					int y = tmp[1] + dy[i];

					if (x < 0 || x >= n || y < 0 || y >= n || map[x][y] > finalShark.size || visit[x][y]) {
						continue;
					}

					visit[x][y] = true;
					q.add(new int[] {x, y, tmp[2] + 1});
				}
			}
			if (b) {
				System.out.println(finalShark.move);
				return;
			}

		}
	}
}
