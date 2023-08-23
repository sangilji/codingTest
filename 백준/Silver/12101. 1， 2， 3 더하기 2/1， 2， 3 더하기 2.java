import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dfs(0, "");
		list.sort(String::compareTo);
		try {
			System.out.println(list.get(m - 1));

		} catch (Exception e) {
			System.out.println(-1);
		}
	}

	private static void dfs(int depth, String s) {
		if (depth > n) {
			return;
		}
		if (depth == n) {
			list.add(s.substring(0, s.length() - 1));
			return;
		}

		for (int i = 1; i <= 3; i++) {
			dfs(depth+i,s+i+"+");
		}
	}

}