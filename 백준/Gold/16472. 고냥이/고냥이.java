import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static List<Integer> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 100_000;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		arr = new int[26];
		int count = 0;
		int start = 0;
		int end = 0;
		int max = 0;
		while (end < s.length()) {
			if (count > n) {
				arr[s.charAt(start) - 'a']--;
				if (arr[s.charAt(start) - 'a'] == 0) {
					count--;
				}
				start++;
				continue;
			}
			int tmp = s.charAt(end) - 'a';
			arr[tmp]++;
			if (arr[tmp] == 1) {
				count++;
			}
			end++;
			if (count <= n) {
				max = Math.max(max, end - start);
			}
		}
		System.out.println(max);
	}

}