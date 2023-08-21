import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static String[][] arr;
	static long[][] dp;
	static int count = 0;
	static final long D = 1_000_000_009;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new String[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			String tmp[] = br.readLine().split("");
			for (int j = 1; j <= m; j++) {
				arr[i][j] = tmp[j-1];
			}
		}
		dp = new long[n+1][m+1];
		dp[n][m] = 1;
		long count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				count = (count + recur(i,j))%D;
			}
		}
		System.out.println(count);
	}

	private static long recur(int x, int y) {

		if (x>n || y> m){
			return 0;
		}
		if (x==n && y ==m){
			return 1;
		}
		if (dp[x][y] != 0) {
			return dp[x][y];
		}
		long tmp = 0;
		if (arr[x][y].equals("S")) {
			tmp = recur(x + 1, y);
		}
		if (arr[x][y].equals("E")) {
			tmp = recur(x, y + 1);
		}
		if (arr[x][y].equals("B")) {
			tmp = (recur(x, y + 1) + recur(x + 1, y)) % D;
		}
		return dp[x][y] = (tmp % D);
	}

}