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
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		int[] ab = new int[n * n];
		int[] cd = new int[n * n];
		int index = 0;
		for (int i : a) {
			for (int j : b) {
				ab[index++] = i + j;
			}
		}
		index = 0;
		for (int i : c) {
			for (int j : d) {
				cd[index++] = i + j;

			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		int start = 0;
		int last = n*n-1;
		long result = 0;
		while (start < n * n && last >= 0) {
			int tmp = ab[start] + cd[last];
			if (tmp < 0) {
				start++;
			} else if (tmp > 0) {
				last--;
			}else{
				long aCount = 0;
				long bCount = 0;
				for (int i = start; i < n * n; i++) {
					if (ab[i] == ab[start]) {
						aCount++;
					}else{
						break;
					}
				}
				for (int i = last; i >=0 ; i--) {
					if (cd[i] == cd[last]) {
						bCount++;
					}else{
						break;
					}
				}
				result+= aCount*bCount;
				start += aCount;
				last -= bCount;
			}
		}
		System.out.println(result);
	}

}