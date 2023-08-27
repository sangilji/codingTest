import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int m;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new char[10][];
		for (int i = 0; i < 10; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		boolean b = false;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (arr[i][j] == '.') {
					b = check(i, j);
				}
				if (b) {
					System.out.println(1);
					return;
				}
			}
		}
		System.out.println(0);

	}

	private static boolean check(int i, int j) {
		int count = 1;
		for (int k = j - 1; k >= 0; k--) {
			if (arr[i][k] == 'X') {
				count++;
			} else {
				break;
			}
		}
		for (int k = j + 1; k < 10; k++) {
			if (arr[i][k] == 'X') {
				count++;
			} else {
				break;
			}
		}
		if (count >= 5) {
			return true;
		}
		count = 1;
		for (int k = i - 1; k >= 0; k--) {
			if (arr[k][j] == 'X') {
				count++;
			} else {
				break;
			}
		}
		for (int k = i + 1; k < 10; k++) {
			if (arr[k][j] == 'X') {
				count++;
			} else {
				break;
			}
		}
		if (count >= 5) {
			return true;
		}
		count = 1;

		for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
			if (arr[k][l] == 'X') {
				count++;
			} else {
				break;
			}
		}
		for (int k = i + 1, l = j + 1; k < 10 && l < 10; k++, l++) {
			if (arr[k][l] == 'X') {
				count++;
			} else {
				break;
			}
		}
		if (count >= 5) {
			return true;
		}

		count = 1;
		for (int k = i - 1, l = j + 1; k >= 0 && l < 10; k--, l++) {
			if (arr[k][l] == 'X') {
				count++;
			} else {
				break;
			}
		}
		for (int k = i + 1, l = j - 1; k < 10 && l >= 0; k++, l--) {
			if (arr[k][l] == 'X') {
				count++;
			} else {
				break;
			}
		}
		if (count >= 5) {
			return true;
		}

		return false;
	}

}