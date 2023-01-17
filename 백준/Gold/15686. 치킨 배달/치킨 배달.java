import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static boolean[] visit;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = s.nextInt();
				if (map[i][j] == 1) {
					house.add(new int[] {i, j});
				}
				if (map[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		visit = new boolean[chicken.size()];
		dfs(new int[m][2], 0, 0);
		System.out.println(result);
	}

	private static void dfs(int[][] selectedChicken, int depth, int start) {
		if (depth == m) {
			searchMin(selectedChicken);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			if (visit[i]) {
				continue;
			}
			visit[i] = true;
			selectedChicken[depth][0] = chicken.get(i)[0];
			selectedChicken[depth][1] = chicken.get(i)[1];
			dfs(selectedChicken, depth + 1, i + 1);
			visit[i] = false;
		}
	}

	private static void searchMin(int[][] selectedChicken) {
		int min = 0;
		for (int i = 0; i < house.size(); i++) {
			int x1 = house.get(i)[0];
			int y1 = house.get(i)[1];
			int tmp = Integer.MAX_VALUE;
			for (int j = 0; j < selectedChicken.length; j++) {
				int x2 = selectedChicken[j][0];
				int y2 = selectedChicken[j][1];

				tmp = Math.min(tmp, Math.abs(x2 - x1) + Math.abs(y2 - y1));
			}
			min += tmp;
		}
		result = Math.min(result,min);
	}
}
