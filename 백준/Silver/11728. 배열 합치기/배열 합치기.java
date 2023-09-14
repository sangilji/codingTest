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
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		int[] result = new int[n + m];
		int i1 = 0;
		int i2 = 0;
		for (int i = 0; i < n + m; i++) {
			if (i1 == n) {
				result[i] = arr2[i2++];
				sb.append(result[i]).append(" ");
				continue;
			}
			if (i2 == m) {
				result[i] = arr[i1++];
				sb.append(result[i]).append(" ");
				continue;
			}
			if (arr[i1] < arr2[i2]) {
				result[i] = arr[i1++];
			} else {
				result[i] = arr2[i2++];
			}
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);

	}

}