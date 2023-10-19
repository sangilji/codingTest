import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static int[] dp;
	static int min = Integer.MAX_VALUE;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		// m = Integer.parseInt(st.nextToken());
		dp = new int[n+1];
		Arrays.fill(dp, -1);
		if (recur(n)) {
			System.out.println(min);
		}else{
			System.out.println(-1);
		}

	}

	private static boolean recur(int cur) {
		if (cur <= 0) {
			return true;
		}
		if (cur < 10) {
			return false;
		}
		if (dp[cur] != -1) {
			return dp[cur] == 1;
		}
		int start = 1;
		while (start <= cur) {
			start*=10;
		}
		int count = 0;
		while (start>1) {
			int a = cur % start;
			start/=10;

			int tmp = 1;
			while (tmp<=a) {
				if (!recur(cur - (a / tmp))) {
					count++;
					if (cur == n) {
						min = Math.min(a / tmp, min);
					}
				}
				tmp *= 10;
			}
		}
		if (count > 0) {
			dp[cur]=1;
		}else{
			dp[cur]= 0;
		}
		return count > 0;
	}



}