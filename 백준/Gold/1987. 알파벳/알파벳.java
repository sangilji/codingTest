import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int k;

	static char[][] arr;
	static int[] alpha;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][];
		alpha = new int[26];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int x, int y) {
		alpha[arr[x][y] - 'A'] = 1;
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if (tx < 0 || ty < 0 || tx >= n || ty >= m || alpha[arr[tx][ty] - 'A'] == 1) {
				continue;
			}
			count = Math.max(count, dfs(tx, ty));
		}

		alpha[arr[x][y] - 'A'] = 0;
		return count + 1;

	}

}