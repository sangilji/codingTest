import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static Map<Integer, Integer>[] list;
	static Map<Integer, Integer> map = new HashMap<>();
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int five = find(n, 5) - find(m, 5) - find(n - m, 5);
		int two = find(n, 2) - find(m, 2) - find(n - m, 2);
		System.out.println(Math.min(five, two));

	}

	private static int find(int n, int div) {
		int count = 0;
		while (n >= 1) {
			count += n / div;
			n /= div;
		}
		return count;
	}

	

}