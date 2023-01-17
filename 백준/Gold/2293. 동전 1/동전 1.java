import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int[] dp = new int[k + 1];
		int[] coin = new int[n];

		for (int i = 0; i < n; i++) {
			coin[i] = s.nextInt();
		}
		Arrays.sort(coin);
		dp[0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (coin[i] <= j) {
					dp[j] += dp[j-coin[i]];
				}
			}
		}
		System.out.println(dp[k]);
	}
}

