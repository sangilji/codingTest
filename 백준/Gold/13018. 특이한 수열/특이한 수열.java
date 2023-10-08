import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int k;

	static int count = 0;

	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		if (n == m) {
			System.out.println("Impossible");
			return;
		}
		int tmp = n - 1 - m;
		if (tmp % 2 == 1) {
			swap(1, n);
		}
		tmp /= 2;
		int start = 2;
		for (int i = 0; i < tmp; i++) {
			swap(start, start + 1);
			start += 2;
		}
		for (int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);

	}

	private static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}