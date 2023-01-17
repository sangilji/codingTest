import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int max = 0;
		int min = 256;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		int answer = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = min; i <= max; i++) {
			int remove = 0;
			int build = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[j][k] >= i) {
						remove += map[j][k] - i;
					}
					if (map[j][k] <= i) {
						build += i - map[j][k];
					}
				}
			}
			int tmp = b + remove;
			if (tmp >= build) {
				if (answer >= remove * 2 + build) {
					answer = remove * 2 + build;
					idx = i;
				}

			}
		}
		System.out.println(answer + " " + idx);
	}
}
