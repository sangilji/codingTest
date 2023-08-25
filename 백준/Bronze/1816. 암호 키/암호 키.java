import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int n;
	static List<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init();
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			long tmp = Long.parseLong(br.readLine());

			if(check(tmp)){
				sb.append("YES\n");
			}else{
				sb.append("NO\n");
			}
		}
		System.out.println(sb);

	}

	private static boolean check(long tmp) {
		for (int j : arr) {
			if (tmp % j == 0) {
				return false;
			}
		}
		return true;
	}

	private static void init() {
		int max = 1000000;
		boolean[] prime = new boolean[max + 1];
		for (int i = 2; i <= Math.sqrt(max); i++) {
			if (prime[i]) {
				continue;
			}
			for (int j = i * i; j <= max; j += i) {
				prime[j] = true;
			}
		}
		for (int i = 2; i <= max; i++) {
			if (!prime[i]) {
				arr.add(i);
			}
		}
	}

}