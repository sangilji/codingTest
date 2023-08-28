import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int max = -123123;
		for (int i = 0; i < m; i++) {
			sum += arr[i];
		}

		max = Math.max(max, sum);
		for (int i = m; i < n; i++) {
			sum -= arr[i - m];
			sum += arr[i];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);

	}

}