import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		for (int i = 123; i <= 999; i++) {
			if (!check(String.valueOf(i))) {
				continue;
			}
			boolean b = true;
			for (int j = 0; j < n; j++) {
				int strike = checkStrike(String.valueOf(i), String.valueOf(arr[j][0]));
				if (i == 328 || i == 324) {
				}
				if (strike != arr[j][1]) {
					b = false;
					break;
				}
				int ball = checkBall(String.valueOf(i), String.valueOf(arr[j][0]));
				if (i == 328 || i == 324) {
				}
				if (ball != arr[j][2]) {
					b= false;
					break;
				}
			}
			if (b) {
				result++;
			}
		}
		System.out.println(result);


	}

	private static int checkBall(String a, String b) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					continue;
				}
				if (a.charAt(i) == b.charAt(j)) {
					count++;
				}
			}
		}
		return count;
	}

	private static int checkStrike(String a, String b) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (a.charAt(i) == b.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	private static boolean check(String s) {
		return !s.contains("0") && s.length()==Arrays.stream(s.split("")).distinct().count();
	}

}