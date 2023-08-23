import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[9];
	static int[] result = new int[7];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		dfs(0, 0, 0);
	}
	static boolean b = false;

	private static void dfs(int current, int sum, int depth) {
		if (b) {
			return;
		}
		if (depth == 7) {
			if (sum == 100) {
				b= true;
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < result.length; i++) {
					sb.append(result[i]).append("\n");
				}
				System.out.println(sb);
			}
			return;
		}
        if (current >= 9) {
			return;
		}
		dfs(current+1, sum, depth);
		result[depth] = arr[current];
		dfs(current+1, sum+arr[current], depth+1);

	}

}