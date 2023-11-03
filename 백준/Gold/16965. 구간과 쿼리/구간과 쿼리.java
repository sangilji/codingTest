import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int k;

	static char[][] arr;
	static int[] visit;
	static List<int[]> list = new ArrayList<>();
	static int[] alpha;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		list.add(new int[] {0, 0});
		visit = new int[n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				list.add(new int[] {b, c});
			} else {
				Arrays.fill(visit, 0);
				sb.append(dfs(b, c)).append("\n");
			}
		}
		System.out.println(sb);

	}

	private static int dfs(int b, int c) {
		if (b == c) {
			return 1;
		}
		visit[b] = 1;
		int tmp = 0;
		for (int i = 1; i < list.size(); i++) {
			if (visit[i] == 1 || i == b) {
				continue;
			}
			if ((list.get(i)[0] < list.get(b)[0] && list.get(b)[0] < list.get(i)[1]) || (list.get(i)[0] < list.get(b)[1]
				&& list.get(b)[1] < list.get(i)[1])) {
				tmp += dfs(i, c);
			}
		}
		if (tmp > 0) {
			return 1;
		}
		return 0;
	}

}