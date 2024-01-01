import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		int[] time = new int[1001];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int j = arr[i][0]; j < arr[i][1]; j++) {
				time[j]++;
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i][0]; j < arr[i][1]; j++) {
				time[j]--;
			}
			max = (int)Math.max(max, Arrays.stream(time).filter(t -> t > 0).count());
			for (int j = arr[i][0]; j < arr[i][1]; j++) {
				time[j]++;
			}
		}
		System.out.println(max);
	}


}