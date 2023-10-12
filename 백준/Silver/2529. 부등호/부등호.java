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

		arr = new int[n];
		visit = new int[10];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken().equals("<") ? "0" : "1");
		}
		for (int i = 0; i <= 9; i++) {
			visit[i] = 1;
			recur(0, i);
			visit[i] = 0;
		}

		if (max < Math.pow(10, n)) {
			System.out.println("0"+max);
		}else{
			System.out.println(max);
		}
		if (min < Math.pow(10, n )) {
			System.out.println("0"+min);
		}else{

			System.out.println(min);
		}
	}

	private static void recur(int depth, long current) {
		if (depth == n) {
			max = Math.max(max, current);
			min = Math.min(min, current);
			return;
		}
		if (arr[depth] == 0) {
			for (int i = (int)((current % 10) + 1); i < 10; i++) {
				if (visit[i] == 1) {
					continue;
				}
				visit[i] = 1;
				recur(depth + 1, current * 10 + i);
				visit[i] = 0;
			}
		} else {
			for (int i = 0; i < current % 10; i++) {
				if (visit[i] == 1) {
					continue;
				}
				visit[i] = 1;
				recur(depth + 1, current * 10 + i);
				visit[i] = 0;
			}
		}
	}

}