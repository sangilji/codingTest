import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;

	static long count = 0;
	static int[] arr;

	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		long start = 0;
		long end = Integer.MAX_VALUE;
		long result = 0;
		while (start <= end) {
			long mid = (start + end) >> 1;
			if (check(mid)) {
				start = mid + 1;
				result = mid;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);

	}

	private static boolean check(long value) {
		long count = 0;
		for (int i = 0; i < n; i++) {
			count += arr[i] / value;
		}
		return count >= m;
	}

}