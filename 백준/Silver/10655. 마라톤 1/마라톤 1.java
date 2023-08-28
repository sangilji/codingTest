import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int[][] tmp = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				tmp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int sum = 0;
		int[] dp = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			sum += dp[i] = dis(tmp[i], tmp[i + 1]);
		}

		int min = Integer.MAX_VALUE;

		for (int i = 1; i < n - 1; i++) {
			min = Math.min(min, sum - dp[i - 1] - dp[i] + dis(tmp[i - 1], tmp[i + 1]));
		}
		System.out.println(min);

	}

	private static int dis(int[] start, int[] last) {
		return Math.abs(start[0] - last[0]) + Math.abs(start[1] - last[1]);
	}

}