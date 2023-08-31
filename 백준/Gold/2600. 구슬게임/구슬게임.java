import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static String result;
	static int count;
	static int[] visit = new int[4];
	static int[][] dp = new int[501][501];
	static int[] ball = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 501; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < 3; i++) {
			ball[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (dfs(a, b)) {
				sb.append("A\n");
			}else{
				sb.append("B\n");
			}
		}
		System.out.println(sb);




	}

	private static boolean dfs(int a, int b) {
		if (a < 0 || b < 0) {
			return true;
		}
		if (a == 0 && b == 0) {
			return false;
		}
		if (dp[a][b] != -1) {
			return dp[a][b] != 0;
		}
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (!dfs(a - ball[i], b)){
				count += 1;
			}
			if (!dfs(a, b -ball[i])){
				count += 1;
			}
		}
		if (count > 0) {
			dp[a][b] = 1;
		}else {
			dp[a][b] = 0;
		}
		return count > 0;
	}

	private static void init() {

	}

}