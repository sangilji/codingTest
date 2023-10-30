import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int u;
	static int d;
	static int[][] dp;

	static int[] arr;
	static int[] tree;
	static List<Integer>[] graph;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		int start = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		bfs(start);

	}

	private static void bfs(int start) {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		q.add(new int[] {start, 0});
		arr[start] = 1;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == m) {
				System.out.println(tmp[1]);
				return;
			}
			int up = tmp[0] + u;
			if (up <= n && arr[up] == 0) {
				q.add(new int[] {up, tmp[1] + 1});
				arr[up] = 1;
			}
			int down = tmp[0] - d;
			if (down >= 1 && arr[down] == 0) {
				q.add(new int[] {down, tmp[1] + 1});
				arr[down] = 1;
			}
		}
		System.out.println("use the stairs");
	}

}