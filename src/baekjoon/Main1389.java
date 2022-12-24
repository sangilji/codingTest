package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1389 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[][] arr = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			arr[a][b] = arr[b][a] = 1;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 5000;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			bfs(arr, i);

		}
		int result = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 1; i < n + 1; i++) {
			int tmp = 0;
			for (int j = 1; j < n + 1; j++) {
				if (i != j) {
					tmp += arr[i][j];
				}
			}
			if (result > tmp) {
				result = tmp;
				idx = i;
			}
		}
		System.out.println(idx);
	}

	private static void bfs(int[][] arr, int i) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, 1});

		boolean[] visit = new boolean[arr.length];
		visit[i] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int j = 1; j < arr.length; j++) {
				if (arr[tmp[0]][j] == 1 && !visit[j]) {
					q.add(new int[] {j, tmp[1] + 1});
					visit[j] = true;
					arr[i][j] = Math.min(arr[i][j], tmp[1]);
				}
			}
		}

	}
}
