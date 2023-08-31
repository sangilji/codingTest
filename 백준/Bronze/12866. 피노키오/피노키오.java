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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		result = br.readLine();
		for (int i = 0; i < n; i++) {
			if (result.charAt(i) == 'A') {
				visit[0]++;
			}
			if (result.charAt(i) == 'C') {
				visit[1]++;
			}
			if (result.charAt(i) == 'G') {
				visit[2]++;
			}
			if (result.charAt(i) == 'T') {
				visit[3]++;
			}
		}
		long mul = 1;
		for (int i = 0; i < 4; i++) {
			mul = (mul*visit[i])%1_000_000_007;
		}
		System.out.println(mul);



	}

	private static void dfs(int sum, int depth) {

	}

	private static void init() {

	}

}