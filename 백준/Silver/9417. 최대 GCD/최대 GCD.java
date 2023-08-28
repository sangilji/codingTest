import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int max = 0;
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					max = Math.max(max,gcd(arr[j], arr[k]));
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static int gcd(int a, int b) {
		if (a > b) {
			int tmp = b;
			b = a;
			a= tmp;
		}
		if (a == 0) {
			return b;
		}
		while (true) {
			if (b % a == 0) {
				return a;
			}
			b %= a;
			int tmp = b;
			b = a;
			a = tmp;
		}
	}
}