import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		System.out.println(bfs(n, m));
	}

	private static int bfs(int n, int m) {
		Queue<int[]> q = new LinkedList<>();
		boolean visit[] = new boolean[100001];
		visit[n] = true;
		q.add(new int[] {n, 0});

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == m) {
				return tmp[1];
			}
			if (0 <= tmp[0] - 1 && !visit[tmp[0] - 1]) {
				visit[tmp[0] - 1] = true;
				q.add(new int[] {tmp[0] - 1, tmp[1] + 1});
			}
			if (tmp[0] + 1 <= 100000 && !visit[tmp[0] + 1]) {
				q.add(new int[] {tmp[0] + 1, tmp[1] + 1});
				visit[tmp[0] + 1] = true;
			}
			if (tmp[0] * 2 <= 100000 && !visit[tmp[0] * 2]) {
				q.add(new int[] {tmp[0] * 2, tmp[1] + 1});
				visit[tmp[0] * 2] = true;
			}
		}
		return -1;
	}
}
