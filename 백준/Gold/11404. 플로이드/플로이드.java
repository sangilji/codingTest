import java.util.Scanner;

public class Main {
	private static final int INF = 10000000;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[][] costs = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					costs[i][j] = 0;
				} else {
					costs[i][j] = INF;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int cost = s.nextInt();
			costs[a][b] = Math.min(costs[a][b], cost);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (costs[i][j] == INF) {
					System.out.print("0 ");
				} else {
					System.out.print(costs[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
