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
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		arr = new int[(n + 1) << 1];
		for (int i = 0; i < b; i++) {
			int tmp = Integer.parseInt(br.readLine());
			arr[tmp]++;
			arr[tmp + k]--;
		}
		for (int i = 1; i <= n; i++) {
			arr[i] += arr[i - 1];
		}
		int result = Integer.MAX_VALUE;
		for (int i = k; i <= n ; i++) {
			result = Math.min(result, arr[i]);
		}
		System.out.println(result);
	}

}