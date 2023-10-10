import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int m;

	static long[][][] arr;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new long[10][1 << 10][n];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 1 << 10; j++) {
				Arrays.fill(arr[i][j], -1);
			}
		}
		long result = 0;
		for (int i = 1; i <= 9 ; i++) {
			result += dfs(i, 1 << i, 1);
			result %= MOD;
		}
		System.out.println(result);

	}

	private static long dfs(int current, int bit, int depth) {

		if (depth == n) {
			if (bit == (1 << 10) - 1) {
				return 1;
			}
			return 0;
		}
		if (arr[current][bit][depth] != -1) {
			return arr[current][bit][depth];
		}
		int tmp = 0;

		if (current == 0) {
			tmp+=dfs(current + 1, bit | 1 << (current + 1), depth + 1);
			tmp%=MOD;
		} else if (current == 9) {
			tmp+=dfs(current - 1, bit | 1 << (current - 1), depth + 1);
			tmp%=MOD;
		} else {
			tmp+=dfs(current + 1, bit | 1 << (current + 1), depth + 1);
			tmp%=MOD;
			tmp+=dfs(current - 1, bit | 1 << (current - 1), depth + 1);
			tmp%=MOD;
		}
		return arr[current][bit][depth] = tmp%MOD;
	}

}