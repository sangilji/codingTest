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
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m+2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] prefix_max = new int[m + 2];
		int[] suffix_max = new int[m + 2];
		for (int i = 1; i <= m; i++) {
			prefix_max[i] = Math.max(arr[i], prefix_max[i-1]);
		}
		for (int i = m; i >=1 ; i--) {
			suffix_max[i] = Math.max(arr[i], suffix_max[i + 1]);
		}

		int result = 0;
		for (int i = 1; i <= m; i++) {
			int min = Math.min(prefix_max[i], suffix_max[i]);
			result += min - arr[i];
		}
		System.out.println(result);
	}

}