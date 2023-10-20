import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static long[] tree;
	static int[] dp;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		dp = new int[n << 1];
		Arrays.fill(dp, 123123123);
		dp[n] = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= Math.sqrt(n); j++) {
				dp[i] = Math.min(dp[i], dp[i + j * j] + 1);
			}
		}
		System.out.println(dp[0]);

	}

	static int min = 100000;

	private static int recur(int cur) {
		if (cur > n) {
			return 12312312;
		}
		if (cur == n) {
			return 0;
		}
		int tmp = 123123123;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			tmp = Math.min(tmp, recur(cur + i * i) + 1);
		}
		return tmp;
	}

}