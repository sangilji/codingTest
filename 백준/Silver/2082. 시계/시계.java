import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[][]  time = {{"###",  "..#",  "###",  "###",  "#.#",  "###",  "###",  "###",  "###",  "###"},
		{"#.#",  "..#",  "..#",  "..#",  "#.#",  "#..",  "#..",  "..#",  "#.#",  "#.#"},
		{"#.#",  "..#",  "###",  "###",  "###",  "###",  "###",  "..#",  "###",  "###"},
		{"#.#",  "..#",  "#..",  "..#",  "..#",  "..#",  "#.#",  "..#",  "#.#",  "..#"},
		{"###",  "..#",  "###",  "###",  "..#",  "###",  "###",  "..#",  "###",  "###"}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] arr = new String[5][4];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			boolean b = true;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 5; k++) {
					String tmp1 = arr[k][i];
					String tmp2 = time[k][j];
					b = check(tmp1, tmp2);
					if (!b) {
						break;
					}
				}
				if (b) {

					sb.append(j);
					if (i == 1) {
						sb.append(":");
					}
					break;
				}
			}

		}
		System.out.println(sb);

	}

	private static boolean check(String tmp1, String tmp2) {
		for (int i = 0; i < 3; i++) {
			if (tmp2.charAt(i) == '.') {
				if (tmp1.charAt(i) == '#') {
					return false;
				}
			}
		}
		return true;
	}

}