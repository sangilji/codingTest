import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static List<Integer> list = new ArrayList<>();

	static int[][] arr = new int[1001][1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1001; i++) {
			Arrays.fill(arr[i], -1);
		}
		arr[0][0] = 0;
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (arr[i][j] == 0) {
					continue;
				}
				arr[i][j] = 1;
				int x = i;
				int y = j;
				while (true) {
					x+=i;
					y+=j;
					if (x > 1000 || y > 1000) {
						break;
					}
					arr[x][y]=0;
				}
			}
		}

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < 1001; i++) {
			for (int j = 1; j < 1001; j++) {
				arr[i][j] += arr[i][j - 1];
			}
		}
		for (int i = 0; i < 1001; i++) {
			for (int j = 1; j < 1001; j++) {
				arr[j][i] += arr[j-1][i];
			}
		}

		for (int i = 0; i < n; i++) {
			m = Integer.parseInt(br.readLine());
			sb.append(arr[m][m]).append("\n");

		}
		System.out.println(sb);
	}

}