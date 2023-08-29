import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static int n;
	static int[][] arr;
	static int[] num;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(max);
	}
	static int max = -1;

	private static void dfs(int depth) {
		if (depth == n) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i][0] <= 0) {
					count++;
				}
			}
			max = Math.max(count, max);
			return;
		}

		if (arr[depth][0] <= 0) {
			dfs(depth+1);
			return;
		}

		boolean b = false;
		for (int i = 0; i < n; i++) {
			if (depth == i || arr[i][0]<=0) {
				continue;
			}
			arr[i][0] -= arr[depth][1];
			arr[depth][0] -= arr[i][1];
			dfs(depth + 1);
			arr[i][0] += arr[depth][1];
			arr[depth][0] += arr[i][1];
			b = true;
		}
		if (!b) {
			dfs(depth + 1);
		}


	}
}