import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static long n;
	static long m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long tmp = n = Long.parseLong(st.nextToken());
		List<Long> arr = new ArrayList<>();
		for (long i = 2; i <= Math.sqrt(n); i++) {
			while (tmp % i == 0) {
				arr.add(i);
				tmp /= i;
			}
		}
		if (tmp != 1) {
			arr.add(tmp);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(arr.size()).append("\n");
		for (Long i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);

	}

}