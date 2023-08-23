import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][][] dp;
	static int[][] arr;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1][3];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n+1; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		StringTokenizer st;
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(1, 1, 2));
	}


	private static int dfs(int x, int y, int current) {
		if (x > n || y > n) {
			return 0;
		}
		if (x == n && y == n) {
			if (isDrink(arr[x][y],current)){
				return 1;
			} else {
				return 0;
			}
		}
		if (dp[x][y][current] != -1) {
			return dp[x][y][current];
		}
		int max = 0;
		if(isDrink(arr[x][y], current)){
			max = Math.max(dfs(x + 1, y, (current + 1) % 3), dfs(x, y + 1, (current + 1) % 3)) +1;
		}
		int max1 = Math.max(dfs(x + 1, y, current), dfs(x, y + 1, current));
		return dp[x][y][current] = Math.max(max, max1);
	}

	private static boolean isDrink(int milk, int current) {
		int tmp = (current+1)%3;
		if (milk == tmp) {
			return true;
		}
		return false;
	}
}