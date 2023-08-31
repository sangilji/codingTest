import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long n;
	static long m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		String tmp = br.readLine();
		m = Long.parseLong(tmp);
		for (int i = 2; i <= Math.sqrt(m); i++) {
			if (m % i == 0) {
				System.out.println("no");
				return;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = tmp.length() - 1; i >= 0; i--) {
			if (tmp.charAt(i) == '6') {
				sb.append('9');
			} else if (tmp.charAt(i) == '9') {
				sb.append('6');
			} else if (tmp.charAt(i) == '3' || tmp.charAt(i) == '4' || tmp.charAt(i) == '7') {
				System.out.println("no");
				return;
			} else {
				sb.append(tmp.charAt(i));
			}
		}
		try {
			n = Long.parseLong(sb.toString());
		} catch (Exception e) {
			System.out.println("no");
			return;
		}
		if (n == 1) {
			System.out.println("no");
			return;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				System.out.println("no");
				return;
			}
		}

		System.out.println("yes");

	}

}