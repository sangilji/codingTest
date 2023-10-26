import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static int[] dp;
	static String[] arr;
	static int[] tree;

	static List<Integer>[] list;

	static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		list = new List[n];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		for (int i = 1; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			list[a].add(i);
		}
		System.out.println(recur(0));

	}

	private static int recur(int cur) {
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < list[cur].size(); i++) {
			q.add(recur(list[cur].get(i)));
		}
		int time = 1;
		int max = 0;
		while (!q.isEmpty()) {
			max = Math.max(max, q.poll() + time);
			time++;
		}
		return max;
	}

}