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
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		m /= n;
		int a = 1;
		int tmp = m;
	
		for (int i = 2; i <= Math.sqrt(m); i++) {
			int mul = 1;
			while (tmp % i == 0) {
				mul *= i;
				tmp /= i;
			}
			if (mul != 1) {
				list.add(mul);
			}
		}
		
		recur(0, a);
		if (resultA > resultB) {
			int swap = resultA;
			resultA = resultB;
			resultB = swap;
		}
		System.out.println(resultA + " " + resultB);
	}

	static int resultA = -1;
	static int resultB = -1;
	static int max = Integer.MAX_VALUE;

	private static void recur(int depth, int a) {
		if (depth == list.size()) {
			int b = (m / a) * n;
			a *= n;
			if (max > Math.abs(a - b)) {
				resultA = a;
				resultB = b;
				max = Math.abs(a - b);
			}
			return;
		}
		recur(depth + 1, a * list.get(depth));
		recur(depth + 1, a);
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