import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[][] arr;
	static long[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			String tmp = br.readLine();
			if (tmp.equals("P")) {
				arr[i][0] = 1;
			} else if (tmp.equals("S")) {
				arr[i][1] = 1;
			} else {
				arr[i][2] = 1;
			}
			for (int j = 0; j < 3; j++) {
				arr[i][j] += arr[i - 1][j];
			}
		}
		int max = 0;

		for (int i = 1; i <= n; i++) {
			int a = arr[i][0] + Math.max(arr[n][1] - arr[i][1], arr[n][2] - arr[i][2]);
			int b = arr[i][1] + Math.max(arr[n][2] - arr[i][2], arr[n][0] - arr[i][0]);
			int c = arr[i][2] + Math.max(arr[n][1] - arr[i][1], arr[n][0] - arr[i][0]);
			max = Math.max(max, Math.max(a, Math.max(b, c)));
		}
		System.out.println(max);


	}

}