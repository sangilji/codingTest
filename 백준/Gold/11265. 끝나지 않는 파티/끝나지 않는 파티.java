import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n + 1][n + 1];
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i == j){
					continue;
				}
				for (int k = 1; k < n + 1; k++) {
					if (i==k || j==k){
						continue;
					}
					map[j][k] = Math.min(map[j][k],map[j][i]+map[i][k]);
				}
			}
		}
		// for (int i = 0; i < n + 1; i++) {
		// 	System.out.println(Arrays.toString(map[i]));
		// }
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (map[a][b]<=c){
				sb.append("Enjoy other party\n");
			} else {
				sb.append("Stay here\n");
			}
		}
		System.out.println(sb);

	}

}