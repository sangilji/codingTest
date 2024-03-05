import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] arr = new int[str.length];
			for (int j = 0; j < M; j++)
				arr[j] = Integer.parseInt(str[j]);
			Arrays.sort(arr);
			System.out.println((arr[arr.length - 1] - arr[0]) * 2);
		}
	}
}