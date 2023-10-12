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

	static int[] arr;
	static List<Integer>[] graph;
	static List<Integer>[] list;
	static int[] visit;
	static int[] in;
	static int[] out;
	static int[] tree;

	static int count = 0;
	static long[][] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];

		recur(0, 1);
		System.out.println(sb);
	}

	private static void recur(int depth,int current) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = current; i <= n; i++) {

			arr[depth] = i;
			recur(depth + 1, i + 1);

		}
	}

}