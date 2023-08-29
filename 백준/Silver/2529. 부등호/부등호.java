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
	static String[] arr;
	static int[] num;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new String[n + 1];
		num = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = st.nextToken();
		}
		dfs(0);
		System.out.println(last);
		System.out.println(first);
	}

	static boolean[] visit = new boolean[10];
	static int count = 0;
	static String first="";
	static String last="";

	private static void dfs(int depth) {
		if (depth == n + 1) {
			if (count == 0) {
				first = Arrays.stream(num).mapToObj(String::valueOf).collect(Collectors.joining());
				count++;
			}else{
				last =  Arrays.stream(num).mapToObj(String::valueOf).collect(Collectors.joining());
			}
			return;
		}

		if (depth == 0) {
			for (int i = 0; i <= 9; i++) {
				num[depth] = i;
				visit[i] = true;
				dfs(depth + 1);
				visit[i] = false;
			}
		} else {
			if (arr[depth].equals("<")) {
				for (int i = num[depth-1]+1; i <= 9; i++) {
					if (visit[i]) {
						continue;
					}
					num[depth] = i;
					visit[i] = true;
					dfs(depth + 1);
					visit[i] = false;
				}
			} else {
				for (int i = 0; i < num[depth-1]; i++) {
					if (visit[i]) {
						continue;
					}
					num[depth] = i;
					visit[i] = true;
					dfs(depth + 1);
					visit[i] = false;
				}
			}

		}
	}

	//
	private static boolean check(int depth) {
		for (int i = 2; i <= depth; i += 2) {
			for (int j = 1; j <= depth - i + 1; j++) {
				boolean b = false;
				for (int k = j; k < j + i / 2; k++) {
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