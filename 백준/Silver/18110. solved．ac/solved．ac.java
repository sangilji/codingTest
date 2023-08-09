import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n == 0) {
			System.out.println(0);
			return;
		}
		int size = (int)Math.round(n * 0.15);
		int[] arr = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		for (int i = 0; i < size; i++) {
			sum -= (arr[i] + arr[n - 1 - i]);
		}
		System.out.println((int)Math.round(sum / (n - size * 2.0)));
	}

}