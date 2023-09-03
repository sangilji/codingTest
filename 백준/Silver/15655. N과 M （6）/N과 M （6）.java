import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000_000;
	static int n;
	static int m;
	static List<Integer>[] list;
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;
	static int[] dp;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		result = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);
	}

	static int[] result;

	private static void dfs(int depth, int current) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = current; i < n; i++) {
			result[depth] = arr[i];
			dfs(depth + 1, i + 1);
		}
	}

	static int max = 0;

	// private static int recur(int depth) {
	// 	if (depth > n) {
	// 		return -123938219;
	// 	}
	// 	if (depth == n) {
	// 		return 0;
	// 	}
	// 	if (dp[depth] != -1) {
	// 		return dp[depth];
	// 	}
	// 	return dp[depth] = Math.max(recur(depth + 1), recur(depth + arr[depth][0]) + arr[depth][1]);
	// }

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