import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int a;
	static int b;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		arr = new int[n];
		Arrays.fill(arr, k);
		int day = 0;
		int tmp = 0;
		while (true) {
			day++;
			for (int i = 0; i < a; i++) {
				arr[tmp] += b;
				tmp = (tmp + 1) % n;
			}
			for (int i = 0; i < n; i++) {
				arr[i]--;
			}
			if (die(arr)) {
				System.out.println(day);
				return;
			}
		}
	}


	private static boolean die(int [] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] == 0) {
				return true;
			}
		}
		return false;
	}

}