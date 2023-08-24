import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int[][] arr = new int[n+1][2];
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] tmp = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			int x = arr[i][0];
			for (int j = 1; j < n + 1; j++) {
				int y = arr[j][1];
				for (int k = 1; k < n + 1; k++) {
					tmp[k] = Math.abs(x - arr[k][0]) + Math.abs(y - arr[k][1]);
				}
				Arrays.sort(tmp);
				int sum = 0;
				for (int k = 1; k < n + 1; k++) {
					sum += tmp[k];
					dist[k] = Math.min(dist[k], sum);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			sb.append(dist[i]).append(" ");
		}
		System.out.println(sb);
	}



}