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
	static long m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static long[] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 100_000;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);

		int start = 0;
		int end = n - 1;
		int count = 0;
		long sum = 0;
		long tmp = n;
		while (0 <= end) {
			if (arr[end] >= m) {
				count++;
				end--;
				tmp--;
			} else {
				break;
			}
		}

		while (start < end) {

			sum = arr[start] + arr[end];
			if (sum + (m / 2) >= m) {
				count++;
				start++;
				end--;
				tmp -= 2;
			} else {
				start++;
			}
		}

		count += (tmp / 3);

		System.out.println(count);
	}

}