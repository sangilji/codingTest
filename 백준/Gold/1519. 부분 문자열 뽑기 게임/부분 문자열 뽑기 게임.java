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
	static int[] dp = new int[1000001];
	static int[] ball = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Arrays.fill(dp,-1);
		if(dfs(n)){
			System.out.println(min);
		}else{
			System.out.println(-1);
		}

	}
	static int min = 10000000;

	private static boolean dfs(int current) {
		if (current <= 0) {
			return true;
		}
		if (current < 10) {
			return false;
		}
		if (dp[current] != -1) {
			return dp[current] == 1;
		}
		int start = 1;
		while (start <= current) {
			start*=10;
		}
		int count = 0;
		while (start>1) {
			int a = current % start;
			start/=10;

			int tmp = 1;
			while (tmp<=a) {
				if (!dfs(current - (a / tmp))) {
					count++;
					if (current == n) {
						min = Math.min(a / tmp, min);
					}
				}
				tmp *= 10;
			}

		}
		if (count > 0) {
			dp[current] = 1;
		}else{
			dp[current] = 0;
		}
		return count > 0;
		
	}

	

	private static void init() {

	}

}