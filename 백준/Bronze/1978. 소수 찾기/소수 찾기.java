import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000;
	static long n;
	static int m;
	static Map<Integer, Integer>[] list;
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr = new int[10001];
		init();
		n = Long.parseLong(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for (int i = 0; i < n; i++) {
			count += arr[Integer.parseInt(st.nextToken())];
		}
		System.out.println(n - count);

	}

	private static void init() {
		arr[1] = 1;
		arr[0] = 1;
		for (int i = 2; i <= Math.sqrt(10000); i++) {
			if (arr[i] == 1) {
				continue;
			}
			for (int j = i + i; j <= 10000; j += i) {
				arr[j] = 1;
			}
		}
	}

}