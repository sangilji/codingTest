import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int count = 50;
	static int n;
	static int m;
	static int x;
	static int y;
	static int z;
	static int k;
	static int[][] arr;
	static int[][] add;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] gun;
	static PriorityQueue<int[]> tree = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
	static Queue<int[]> newTree = new ArrayDeque<>();
	static Queue<int[]> dieTree = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		add = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				add[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = 5;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			tree.add(new int[] {x, y, z});
		}
		for (int i = 0; i < k; i++) {
			spring();
			summer();
			autumn();
			winter();
		}
		System.out.println(tree.size());

	}

	private static void spring() {
		int size = tree.size();
		for (int i = 0; i < size; i++) {
			int[] tmp = tree.poll();
			int x = tmp[0];
			int y = tmp[1];
			int age = tmp[2];
			if (arr[x][y] >= age) {
				arr[x][y] -= age;
				tmp[2] += 1;
				newTree.add(tmp);
			} else {
				dieTree.add(tmp);
			}
		}
	}

	private static void summer() {
		while (!dieTree.isEmpty()) {
			int[] tmp = dieTree.poll();
			int x = tmp[0];
			int y = tmp[1];
			int age = tmp[2] / 2;
			arr[x][y] += age;
		}
	}

	private static void autumn() {
		while (!newTree.isEmpty()) {
			int[] tmp = newTree.poll();
			int x = tmp[0];
			int y = tmp[1];
			int age = tmp[2];
			if (age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int tx = x + dx[i];
					int ty = y + dy[i];
					if (tx < 1 || ty < 1 || tx > n || ty > n) {
						continue;
					}
					tree.add(new int[] {tx, ty, 1});
				}
			}
			tree.add(tmp);

		}
	}

	private static void winter() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] += add[i][j];
			}
		}
	}

}