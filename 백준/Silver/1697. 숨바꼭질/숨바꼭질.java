import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		bfs();

	}

	private static void bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		boolean[] visit = new boolean[100001];

		q.add(new int[] {n, 0});
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == m) {
				System.out.println(tmp[1]);
				return;
			}
			if (tmp[0] - 1 >= 0 && !visit[tmp[0] - 1]) {
				visit[tmp[0] - 1] = true;
				q.add(new int[] {tmp[0] - 1, tmp[1] + 1});
			}
			if (tmp[0] + 1 <= 100000 && !visit[tmp[0] + 1]) {
				visit[tmp[0] + 1] = true;
				q.add(new int[] {tmp[0] + 1, tmp[1] + 1});
			}
			if (tmp[0] * 2 <= 100000 && !visit[tmp[0] * 2]) {
				visit[tmp[0] * 2] = true;
				q.add(new int[] {tmp[0] * 2, tmp[1] + 1});
			}
		}
	}

	static int result = 0;

}