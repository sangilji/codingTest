import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
		int x =arr[n/2][0];
		Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
		int y = arr[n/2][1];
		long result = 0;
		for (int i = 0; i < n; i++) {
			result+= Math.abs(x-arr[i][0]) + Math.abs(y-arr[i][1]);
		}
		System.out.println(result);
	}

}