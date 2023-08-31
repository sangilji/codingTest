import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] counts;
	static int[][] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		counts = new int[n + 1];
		num = new int[n + 1][n + 1];
		m = Integer.parseInt(br.readLine());
		boolean[] print = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			num[x][y] = k;
			counts[y]++;
			print[x] = true;
		}

		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[n + 1];
		int[] arr = new int[n + 1];
		while (true) {
			for (int i = 1; i <= n; i++) {
				if (!visit[i] && counts[i] == 0) {
					visit[i] = true;
					q.add(i);
					if (arr[i] == 0) {
						arr[i] = 1;
					}
				}
			}
			if (q.isEmpty()) {
				break;
			}
			while (!q.isEmpty()) {
				int tmp = q.poll();
				for (int i = 1; i <= n; i++) {
					if (num[tmp][i] != 0) {
						arr[i] += arr[tmp] * num[tmp][i];
						counts[i]--;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			if (!print[i]) {
				sb.append(i).append(" ").append(arr[i]).append("\n");
			}
		}
		System.out.println(sb);

	}

}