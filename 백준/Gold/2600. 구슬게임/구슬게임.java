import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[501][501];
		for (int i = 0; i < 501; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			int k1 = Integer.parseInt(st.nextToken());
			int k2 = Integer.parseInt(st.nextToken());
			if (recur(k1, k2)) {
				sb.append("A\n");
				continue;
			}
			sb.append("B\n");
		}
		System.out.println(sb);


	}

	private static boolean recur(int k1, int k2) {
		if (k1 < 0 || k2 < 0) {
			return true;
		}
		if (k1 == 0 && k2 == 0) {
			return false;
		}
		if (dp[k1][k2] != -1) {
			return dp[k1][k2] == 1;
		}
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (!recur(k1 - arr[i], k2)) {
				count++;
			}
			if (!recur(k1, k2 - arr[i])) {
				count++;
			}
		}
		if (count > 0) {
			dp[k1][k2]=1;
		}else{
			dp[k1][k2]=0;
		}
		return count > 0;
	}

}