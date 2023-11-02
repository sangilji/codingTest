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
	static int[][] dp;

	static int[] arr;
	static List<Integer>[] list;
	static int[] visit;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		visit = new int[n + 1];
		list = new List[n + 1];
		for (int i = 1; i <=n; i++) {
			list[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 1; i <=n; i++) {
			if (visit[i] == 0) {
				count+=dfs(i);
			}
		}
		if (count <= k) {
			System.out.println(count);
		}else{
			System.out.println("Oh no");
		}

	}

	private static int dfs(int cur) {
		visit[cur] = 1;
		int tmp = arr[cur];
		for (int i = 0; i < list[cur].size(); i++) {
			if (visit[list[cur].get(i)] == 1) {
				continue;
			}
			tmp = Math.min(tmp, dfs(list[cur].get(i)));
		}
		return tmp;
	}

}