import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int k;
	static int m;

	static int[] arr;
	static int[] sum;
	static int[] num;
	static int[] arr2;

	static long[] tree_min;
	static long[] tree_max;
	static long[] lazy;

	static int min = Integer.MAX_VALUE;
	static int[][] dp;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		recur(1, 0);
		System.out.println(sb);
	}

	private static void recur(int depth, int count) {
		if (count == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		if (depth > n) {
			return;
		}
		arr[count] = depth;
		recur(depth + 1, count + 1);
		recur(depth + 1, count);
	}

}