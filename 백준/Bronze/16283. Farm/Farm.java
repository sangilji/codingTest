import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (a * i + b * (n - i) == w) {
				sb.append(i).append(" ").append(n - i);
				count++;
			}
		}
		if (count != 1) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}

	}
}