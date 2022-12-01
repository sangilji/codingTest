package baekjoon;

public class museLive {

	public int solution(int n, int k) {
		int[][] dp = new int[k + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			dp[1][i] = 1;
		}

		int sum = 1;
		for (int i = 2; i <= k; i++) {
			sum += i;
			for (int j = sum; j <= n; j++) {
				dp[i][j]= dp[i-1][j-i] + dp[i][j-i];
			}
		}
		System.out.println(dp[k][n]);
		return dp[k][n];
	}

	public static void main(String[] args) {
		museLive m = new museLive();
		m.solution(10, 2);
	}
}
