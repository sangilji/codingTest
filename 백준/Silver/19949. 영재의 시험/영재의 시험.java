import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n;
	static int m;
	static int[] arr;

	static int count = 0;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		recur(0, 0, 0);
		System.out.println(sum);

	}

	private static void recur(int depth, int count, long current) {
		if (depth == 10) {
			if (count >= 5) {
				sum++;
			}
			return;
		}
		for (int i = 1; i <= 5; i++) {
			if (current > 10 && (current % 100) / 10 == current % 10 && current % 10 == i) {
				continue;
			}
			if (arr[depth] == i) {
				recur(depth + 1, count + 1, current * 10 + i);
			} else {
				recur(depth + 1, count, current * 10 + i);
			}
		}
	}

}