import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new char[n][];
			for (int j = 0; j < n; j++) {
				arr[j] = br.readLine().toCharArray();
			}
			int count = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (check(j, k)){
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);

	}

	private static boolean check(int j, int k) {
		if (k+2 < m) {
			if (arr[j][k] == '>' && arr[j][k + 1] == 'o' && arr[j][k + 2] == '<') {
				return true;
			}
		}
		if (j + 2 < n) {
			if (arr[j][k]=='v' && arr[j+1][k]=='o' && arr[j+2][k]=='^'){
				return true;
			}
		}
		return false;
	}

}