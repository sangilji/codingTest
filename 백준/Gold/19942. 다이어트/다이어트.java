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
	static int mp;
	static int mf;
	static int ms;
	static int mv;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][5];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new int[n + 1];


		recur(1, 0, 0, 0, 0, 0);
		if (min == Long.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		sb.append(min).append("\n");
		sb.append(result);
		System.out.println(sb);

	}
	static String result = "";

	private static void recur(int depth, int p, int f, int s, int v, int cost) {

		if (depth == n + 1) {
			if (p >= mp && f >= mf && s >= ms && v >= mv) {
				if (min > cost) {
					min = cost;
					StringBuilder tmp = new StringBuilder();
					for (int i = 1; i <= n; i++) {
						if (visit[i] == 1) {
							tmp.append(i).append(" ");
						}
					}
					result = tmp.toString();
				} else if (min == cost) {
					StringBuilder tmp = new StringBuilder();
					for (int i = 1; i <= n; i++) {
						if (visit[i] == 1) {
							tmp.append(i).append(" ");
						}
					}
					if (result.compareTo(tmp.toString()) > 0) {
						result = tmp.toString();
					}
				}
			}
			return;
		}
		visit[depth] = 1;
		recur(depth + 1, p + arr[depth][0], f + arr[depth][1], s + arr[depth][2], v + arr[depth][3],
			cost + arr[depth][4]);
		visit[depth] = 0;
		recur(depth + 1, p, f, s, v, cost);

	}

}