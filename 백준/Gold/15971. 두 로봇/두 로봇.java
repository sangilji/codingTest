import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int k;

	static int[][] arr;
	static int[] visit;
	static List<int[]>[] list;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		list = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		visit = new int[n + 1];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[t1].add(new int[] {t2, c});
			list[t2].add(new int[] {t1, c});
		}
		dfs(a, b);
		System.out.println(sum-count);
	}
	static int sum = 0;

	private static boolean dfs(int cur, int last) {
		visit[cur] = 1;
		if (cur == last) {
			return true;
		}
		boolean bool = false;

		for (int i = 0; i < list[cur].size(); i++) {
			int[] tmp = list[cur].get(i);
			if (visit[tmp[0]] == 1) {
				continue;
			}
			if (dfs(tmp[0], last)) {
				count = Math.max(count, tmp[1]);
				sum += tmp[1];
				bool = true;
			}
		}
		return bool;
	}

}