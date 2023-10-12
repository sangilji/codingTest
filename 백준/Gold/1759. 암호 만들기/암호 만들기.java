import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int r;
	static int m;

	static String[] arr;
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
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new String[m];
		visit = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		recur(0, 0);
		System.out.println(sb);


	}
	static String result = "";

	private static void recur(int depth, int count) {
		if (depth == m) {
			if (count == n) {
				if (check()) {
					for (int i = 0; i < m; i++) {
						if (visit[i] == 1) {
							sb.append(arr[i]);
						}
					}
					sb.append("\n");
				}
			}
			return;
		}
		visit[depth] = 1;
		recur(depth + 1, count + 1);
		visit[depth] =0;
		recur(depth + 1, count);
	}

	static String[] alpha = {"a", "e", "i", "o", "u"};
	private static boolean check() {
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			if (visit[i] == 0) {
				continue;
			}
			for (int j = 0; j < 5; j++) {
				if (arr[i].equals(alpha[j])) {
					cnt++;
					break;
				}
			}
		}
		return cnt >= 1 && n - cnt >= 2;
	}

}