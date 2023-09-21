import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int m;

	static long count = 0;

	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		s = br.readLine();
		n = s.length();
		System.out.println(dfs(0, 0, 0, false));

	}

	private static long dfs(int depth, int a, int b,boolean able) {
		if (depth == n) {
			if (a != 3 && b != 3 && able) {
				return 1;
			}
			return 0;
		}
		if (a == 3 || b == 3) {
			return 0;
		}
		long tmp = 0;
		if (s.charAt(depth) == '_') {
			tmp+= dfs(depth+1,a + 1, 0, able)* 5;
			tmp += dfs(depth + 1, 0, b + 1, true);
			tmp += dfs(depth + 1, 0, b + 1, able) * 20;
		} else {
			boolean bowl = check(s.charAt(depth));
			if (bowl) {
			tmp+=	dfs(depth + 1, a + 1, 0, able);
			}else{
				if (s.charAt(depth)=='L'){
					able=true;
				}
				tmp+=dfs(depth + 1, 0, b+1, able);
			}
		}
		return tmp;
	}

	private static boolean check(char c) {
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}

}