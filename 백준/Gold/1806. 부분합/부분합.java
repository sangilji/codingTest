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
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Long, Integer> map = new HashMap<>();
	static long[] prefix_gcd;
	static long[] suffix_gcd;
	static int[] arr;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 150_000;
	static String s;
	static int result = 0;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int count = 0;
		while (true) {
			if (end >= n) {
				if (sum < m || start==end) {
					break;
				}else{
					min = Math.min(min, count);
					sum -= arr[start++];
					count--;
				}
				continue;
			}
			if (sum < m) {
				sum += arr[end++];
				count++;
			} else {
				min = Math.min(min, count);
				sum -= arr[start++];
				count--;
			}
		}
		if (sum >= m) {
			min = Math.min(min, count);
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(min);
	}



}