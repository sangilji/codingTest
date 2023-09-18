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
	static int[] arr;
	static long[] tree;
	static long[] lazy_mul;
	static long[] lazy_sum;
	static int SIZE = 150_000;
	static String s;
	static int result = 0;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());

		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = n - 1;
		int result = 0;
		while (start < end) {
			int a = arr[start];
			int b = arr[end];
			int size = end - start - 1;
			if (a < b) {
				start++;
			} else {
				end--;
			}
			result = Math.max(Math.min(a, b) * size,result);
		}
		System.out.println(result);
	}

}