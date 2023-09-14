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

	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static List<Integer> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[][] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 100_000;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[4][m];
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int[] a = new int[m * m];
			int[] b = new int[m * m];
			int index = 0;
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < m; k++) {
					a[index] = arr[0][j] + arr[1][k];
					b[index++] = arr[2][j] + arr[3][k];
				}
			}
			Arrays.sort(a);
			Arrays.sort(b);
			sb.append(find(a, b)).append("\n");
		}
		System.out.println(sb);

	}

	private static int find(int[] a, int[] b) {
		int sum = 40000001;
		int answer = 40000001;
		int start = 0;
		int last = m * m - 1;
		while (start < m * m && last >= 0) {
			int tmp = a[start] + b[last];
			if (tmp < n) {
				start++;
			} else if (tmp > n) {
				last--;
			} else {
				return n;
			}
			if (Math.abs(tmp - n) < sum) {
				answer = tmp;
				sum = Math.abs(tmp - n);
			} else if (Math.abs(tmp - n) == sum) {
				answer = Math.min(tmp, answer);
			}
		}
		return answer;
	}

}