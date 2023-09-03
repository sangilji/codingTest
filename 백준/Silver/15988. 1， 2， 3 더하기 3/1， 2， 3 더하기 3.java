import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static List<Integer> list = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static long[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		n = 1000000;
		dp = new int[n + 1];
		dp[n] = 1;
		for (int j = n - 1; j >= 0; j--) {
			for (int k = 1; k <= 3; k++) {
				if (j + k <= n) {
					dp[j] = (dp[j] + dp[j + k]) % MOD;
				}
			}
		}
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());

			sb.append(dp[1000000 - n]).append("\n");
		}
		System.out.println(sb);

	}

	private static boolean find(int i, int c) {
		int div = 10;
		while (i >= 1) {
			if (i % div == c) {
				return true;
			}
			i /= 10;
		}
		return false;
	}

	private static int recur(int depth) {
		if (depth > n) {
			return 0;
		}
		if (depth == n) {
			return 1;
		}
		if (dp[depth] != -1) {
			return dp[depth];
		}
		dp[depth] = ((recur(depth + 1) + recur(depth + 2)) % MOD + recur(depth + 3)) % MOD;
		return dp[depth];
	}

	private static int[] findPrime() {
		int[] prime = new int[4_000_010];
		for (int i = 2; i <= Math.sqrt(4_000_010); i++) {
			if (prime[i] == 1) {
				continue;
			}
			for (int j = i + i; j < 4_000_010; j += i) {
				prime[j] = 1;
			}
		}
		return prime;
	}

	private static long gcd(long a, long b) {
		if (a > b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		if (a == 0) {
			return b;
		}
		while (true) {
			if (b % a == 0) {
				return a;
			}
			b %= a;

			long tmp = a;
			a = b;
			b = tmp;
		}

	}

}