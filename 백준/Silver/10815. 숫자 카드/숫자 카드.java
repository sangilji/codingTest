import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] card;
	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		card = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		int a = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			int num = Integer.parseInt(st.nextToken());
			search(num);
		}
		System.out.println(sb);
	}

	private static void search(int num) {
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int m = card[mid];

			if (num < m) {
				right = mid - 1;
			} else if (num > m) {
				left = mid + 1;
			} else {
				sb.append("1 ");
				return;
			}
		}
		sb.append("0 ");
		return;
	}
}