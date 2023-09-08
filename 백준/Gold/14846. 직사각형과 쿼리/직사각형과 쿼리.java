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
	static int [][][] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 150_000;
	static String s;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1][11];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				System.arraycopy(arr[i][j - 1], 0, arr[i][j], 0, 11);
				int tmp = Integer.parseInt(st.nextToken());
				arr[i][j][tmp]+=1;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 0; k < 11; k++) {
					arr[i][j][k] += arr[i - 1][j][k];
				}
			}
		}

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int count = 0;
			for (int j = 0; j < 11; j++) {
				if (arr[x2][y2][j] - arr[x2][y1 - 1][j] - arr[x1 - 1][y2][j] + arr[x1 - 1][y1 - 1][j] > 0) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb);


	}



}