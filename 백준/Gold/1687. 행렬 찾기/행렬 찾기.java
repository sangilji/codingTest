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
	static int[][] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 150_000;
	static String s;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String tmp = br.readLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = arr[i][j - 1] + (int)tmp.charAt(j - 1) - '0';
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] += arr[i - 1][j];
			}
		}
		// for (int i = 1; i <= n; i++) {
		// 	for (int j = 1; j <= m; j++) {
		// 		System.out.print(arr[i][j]);
		// 	}
		// 	System.out.println();
		// }
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				getResult(i, j);
			}
		}
		System.out.println(result);

	}

	private static void getResult(int i, int j) {
		for (int k = 1; k <= i; k++) {
			for (int l = 1; l <= j; l++) {
				int mul = (i - k + 1) * (j - l + 1);
				if (mul < result) {
					break;
				}
				int tmp = arr[i][j] - arr[k - 1][j] - arr[i][l - 1] + arr[k - 1][l - 1];
				if (tmp == 0) {
					result = Math.max(result, mul);
				}
			}
		}

	}

}