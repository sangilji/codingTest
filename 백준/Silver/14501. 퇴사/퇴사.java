import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int r;
	static int m;

	static int[][] arr;
	static int[] arr2;
	static List<Integer>[] graph;
	static List<Integer>[] list;
	static int[] visit;
	static int[] in;
	static int[] out;
	static int[] tree;

	static int count = 0;
	static long[][] dp;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		arr = new int[n][2];


		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(0, 0);
		System.out.println(max);
	}

	private static void recur(int depth, int sum) {

		if (depth > n) {
			return;
		}
		if (depth == n) {
			max = Math.max(sum, max);
			return;
		}

		recur(depth + arr[depth][0], sum + arr[depth][1]);
		recur(depth + 1, sum);

	}

}