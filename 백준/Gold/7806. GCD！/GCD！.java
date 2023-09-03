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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while ((s = br.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(s);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int tmp = m;
			for (int i = 2; i <= Math.sqrt(m); i++) {
				while (tmp % i == 0) {
					map.put(i, map.getOrDefault(i, 0) + 1);
					tmp /= i;
				}
			}
			if (tmp != 1) {
				map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			}
			int result = 1;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int num = entry.getKey();
				int count = 0;
				tmp = n;
				while (tmp >= 1) {
					count += tmp / num;
					tmp /= num;
				}

				if (count != 0) {
					result *= Math.pow(num, Math.min(entry.getValue(), count));
				}
			}
			sb.append(result).append("\n");
			map.clear();
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