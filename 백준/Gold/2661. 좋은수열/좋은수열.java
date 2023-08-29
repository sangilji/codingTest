import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dfs(0);


	}
	static boolean b = false;
	private static void dfs(int depth) {
		if (b) {
			return;
		}

		if (!check(depth)) {
			return;
		}
		if (n == depth) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= n; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
			b=true;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			arr[depth+1] = i;
			dfs(depth + 1);
		}
	}
//
	private static boolean check(int depth) {
		for (int i = 2; i <= depth; i += 2) {
			for (int j = 1; j <= depth - i + 1; j++) {
				boolean b = false;
				for (int k = j; k < j + i/2 ; k++) {
					if (arr[k] != arr[k + i / 2]) {
						b = true;
					}
				}
				if (!b) {
					return false;
				}
			}
		}
		return true;
	}

}