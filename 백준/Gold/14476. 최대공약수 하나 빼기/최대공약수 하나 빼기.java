import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000_007;
	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Long, Integer> map = new HashMap<>();
	static long[] prefix_gcd;
	static long[] suffix_gcd;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 150_000;
	static String s;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		long[] arr = new long[n + 1];
		prefix_gcd = new long[n + 2];
		suffix_gcd = new long[n + 2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefix_gcd[i] = gcd(prefix_gcd[i - 1], arr[i]);
		}
		for (int i = n; i >= 1; i--) {
			suffix_gcd[i] = gcd(suffix_gcd[i + 1], arr[i]);
		}
		long answer = -1;
		int index = -1;
		for (int i = 1; i <= n; i++) {
			long result = gcd(prefix_gcd[i - 1], suffix_gcd[i + 1]);
			if (arr[i] % result == 0) {
				continue;
			}
			if (answer<result) {
				answer = result;
				index = i;
			}
		}
		if (answer == -1) {
			System.out.println(answer);
			return;
		}
		sb.append(answer).append(" ").append(arr[index]);
		System.out.println(sb);

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
/*
3
3 1 2
2 1 4
 */

}