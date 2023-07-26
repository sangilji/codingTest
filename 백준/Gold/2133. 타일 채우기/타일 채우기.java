import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		
		if (n % 2 == 1) {
			System.out.println(0);
			return;
		}
		dp[2] = 3;
		dp[0] = 1;
		for (int i = 4; i <= n; i += 2) {
			for (int j = 2; j <= i; j += 2) {
				if (j == 2) {
					dp[i] += 3 * dp[i - j];
				} else {
					dp[i] += 2 * dp[i - j];
				}
			}
		}
		System.out.println(dp[n]);
	}

}