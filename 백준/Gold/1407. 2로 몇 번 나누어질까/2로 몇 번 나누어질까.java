import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
	static long n;
	static long m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		System.out.println(f(m) - f(n - 1));
	}

	private static long f(long num) {
		long start = 1;
		long result = num;
		num/=2;
		while (true) {
			if (num == 0) {
				break;
			}
			result+= start*num;
			start*=2;
			num/=2;
		}
		return result;
	}
}