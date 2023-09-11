import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Long, Integer> map = new HashMap<>();
	static long[] prefix_gcd;
	static long[] suffix_gcd;
	static int[] arr;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 150_000;
	static String s;
	static int result = 0;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		n = arr.length;
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(recur(0));

	}

	private static int recur(int depth) {
		if (depth == n) {
			return 1;
		}
		if (dp[depth] != -1) {
			return dp[depth];
		}
		int tmp = 0;
		if ((depth < n - 1 && arr[depth]==1) || (depth < n - 1 && arr[depth] == 2 && arr[depth + 1] <= 6)) {
			tmp = (tmp + recur(depth + 2)) % MOD;
		}
		if (arr[depth]!= 0) {
			tmp = (tmp + recur(depth + 1)) % MOD;
		}
		return dp[depth] = tmp;
	}

}