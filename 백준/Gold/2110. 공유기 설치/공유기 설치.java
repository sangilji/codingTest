import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static List<Long> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static long[] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 100_000;
	static long[] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);

		long start = 1;
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

	private static boolean check(long mid) {
		int count = 1;
		int start = 0;
		for (int i = 1; i < n; i++) {
			long tmp = arr[i] - arr[start];
			if (tmp >= mid) {
				count++;
				start = i;
			}
		}
		return count >= m;
	}

}