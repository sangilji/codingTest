import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	static int[] arr;
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
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 1;
		int end = 2_000_000_000;
		int result = 0;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (check(mid)) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(result);

	}

	private static boolean check(int num) {
		long result = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > num) {
				result += (arr[i] - num);
			}
		}
		return result >= m;
	}

}