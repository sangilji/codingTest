import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[][] dp;

	static int[] arr;
	static int[] tree;
	static List<Integer>[] graph;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String a = " " + br.readLine();
		String b = " " + br.readLine();
		n = a.length();
		m = b.length();
		dp = new int[n][m];
		int[][][] parent = new int[n][m][2];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					parent[i][j][0] = i - 1;
					parent[i][j][1] = j - 1;
				} else {
					if (dp[i - 1][j] > dp[i][j - 1]) {
						dp[i][j] = dp[i - 1][j];
						parent[i][j][0] = i - 1;
						parent[i][j][1] = j;
					} else {
						dp[i][j] = dp[i][j - 1];
						parent[i][j][0] = i;
						parent[i][j][1] = j - 1;
					}
				}
			}
		}
		int tmp = dp[n-1][m-1];
		sb.append(tmp).append("\n");
		Stack<Character> s = new Stack<>();
		int x = n - 1;
		int y = m - 1;
		while (tmp != 0) {
			if (dp[x][y] == tmp && a.charAt(x)== b.charAt(y)) {
				tmp--;
				s.push(a.charAt(x));
			}
			int tx = parent[x][y][0];
			int ty = parent[x][y][1];
			x= tx;
			y =ty;
		}
		while (!s.isEmpty()) {
			sb.append(s.pop());
		}
		System.out.println(sb);

	}

}