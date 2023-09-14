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
	static List<Long> list = new ArrayList<>();
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

		long start = 1;
		long end = 2;
		while (start != end) {
			long tmp = (end + start) * (end - start);
			if (tmp < n) {
				end++;
			} else if (tmp > n) {
				start++;
			} else {
				list.add(end);
				end++;
				start++;
			}
		}
		if (list.isEmpty()) {
			System.out.println(-1);
			return;
		}
		for (long i : list) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);

	}

}