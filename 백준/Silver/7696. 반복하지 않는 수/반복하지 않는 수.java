import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] arr = new int[30000001];
	static int[] arr2 = new int[1000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			arr[i] = 1 << i;
			arr2[i] = i;
		}
		int i = 10;
		int index = 10;
		while (true) {
			if (arr[i / 10] == 0) {
				i++;
				continue;
			}

			if ((arr[i / 10] & arr[i % 10]) == 0) {
				arr[i] = arr[i/10] | arr[i%10];
				arr2[index] = i;
				index++;
			}
			i++;
			if (index > 1000000) {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			sb.append(arr2[n]).append("\n");

		}
		System.out.println(sb);
	}
}