import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[] dp_left;
	static int[] dp_right;
	static int[] arr;
	static int[] tree;
	static List<Integer>[] graph;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n + 2];
		dp_left = new int[n + 2];
		dp_right = new int[n + 2];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp_left[i] = Math.max(dp_left[i], dp_left[j] + 1);
				}
			}
		}

		for (int i = n; i >= 1; i--) {
			for (int j = n + 1; j > i; j--) {
				if (arr[i] > arr[j]) {
					dp_right[i] = Math.max(dp_right[i], dp_right[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= n ; i++) {
			max = Math.max(max, dp_right[i] + dp_left[i]-1);
		}
		System.out.println(max);
	}

}