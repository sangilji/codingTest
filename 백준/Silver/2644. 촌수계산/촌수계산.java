import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] nodes;
	static int n;
	static int start;
	static int end;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nodes = new List[n + 1];
		for (int i = 1; i < n + 1; i++) {
			nodes[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a].add(b);
			nodes[b].add(a);
		}
		bfs(start, end);

	}

	private static void bfs(int start, int end) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start, 0});
		boolean[] visit = new boolean[n + 1];
		visit[start] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == end) {
				System.out.println(tmp[1]);
				return;
			}
			for (int i = 0; i < nodes[tmp[0]].size(); i++) {
				int next = nodes[tmp[0]].get(i);
				if (visit[next]) {
					continue;
				}
				visit[next] = true;
				q.add(new int[] {next, tmp[1] + 1});
			}
		}

		System.out.println(-1);

	}

}