import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int[] num;
	static int[] min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = new int[4];
		for (int i = 0; i < 4; i++) {
			min[i] = Integer.parseInt(st.nextToken());
		}

		arr = new int[n][5];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0,0,0,0,0,0,"");
		if (max == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(max);
		System.out.println(maxString);
	}
	static int max = Integer.MAX_VALUE;
	static String maxString = "";

	private static void dfs(int p, int f, int s, int v, int sum, int start, String result) {

		if (p >= min[0] && f >= min[1] && s >= min[2] && v >= min[3]) {
			if (max > sum) {
				max = sum;
				maxString = result.trim();
			}
			return;
		}
		for (int i = start; i < n; i++) {
			dfs(p+arr[i][0],f+arr[i][1],s+arr[i][2],v+arr[i][3],sum+arr[i][4],i+1,result+(i+1)+" ");
		}
	}
}