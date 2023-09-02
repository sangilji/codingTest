import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static List<Integer> list = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static long[] arr;

	public static void main(String[] args) throws IOException {
		// 30    1 2 3 5 6 10 15 30    2 3 5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int count = 0;
		int count2 = 0;
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				for (int l = 0; l <= x; l++) {
					for (int o = 0; o <= y; o++) {
						if (i >= l && j >= o) {
							continue;
						}
						int n = Math.abs(l - i);
						int m = Math.abs(j - o);
						int tmp = (int)gcd(n, m);
						if (k == tmp + 1) {
							count++;
							if (i > l && j < o || i < l && j > o) {
								count2++;
							}
						}

					}
				}
			}
		}
		System.out.println(count - count2 / 2);
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

	private static void recur(int depth, int a) {
		recur(depth + 1, a * list.get(depth));
		recur(depth + 1, a);
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