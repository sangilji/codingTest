import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n;
	static int m;

	static long count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			count = 0;
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					long val = arr[k] - arr[j];
					long start = k + 1;
					long end = n - 1;
					while (start <= end) {
						int mid = (int)((start + end) >> 1);
						long tmp = arr[mid] - arr[k];
						if (tmp == val) {
							count++;
							break;
						} else if (tmp < val) {
							start = mid + 1;
						} else {
							end = mid - 1;
						}
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);

	}

}