import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1000000000;
	static int n;
	static int k;
	static int m;

	static int[] arr;
	static int[] cost;

	static int[] dx = {1, 0};
	static int[] dy = {0, 1};

	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int max = 0;
		Arrays.sort(arr);
		int count = 1;
		for (int i = n-1; i >=0 ; i--) {
			max = Math.max(max, arr[i] * count++);
		}
		System.out.println(max);


	}



}