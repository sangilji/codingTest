import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int m;
	static int k;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] prime;

	public static void game() {
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}

	static int count = 0;
	static StringBuilder sb = new StringBuilder();

	private static void dfs(int current, int depth) {
		if (depth == n) {
			sb.append(current).append("\n");
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (check(current * 10 + i)) {
				dfs(current * 10 + i, depth + 1);
			}
		}
	}

	private static boolean check(int cur) {
		for (int i = 2; i <= Math.sqrt(cur); i++) {
			if (cur % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void output() {

		System.out.println(sb);

	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());

	}

	public static void main(String[] args) throws IOException {
		// 여기에 코드를 작성해주세요.
		input();
		game();
		output();
	}

}