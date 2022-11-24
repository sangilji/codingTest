package baekjoon;

import java.util.Scanner;

public class Main1019 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] count = new int[10];
		int point = 1;
		int start = 1;
		while (n >= start) {
			while (n % 10 != 9 && start <= n) {
				cal(n, count, point);
				n--;
			}

			while (start % 10 != 0 && start <= n) {
				cal(start, count, point);
				start++;
			}

			if (n < start) {
				break;
			}

			start /= 10;
			n /= 10;
			for (int i = 0; i < 10; i++) {
				count[i] += (n - start + 1) * point;
			}
			point *= 10;
		}
		for (int i = 0; i < 10; i++) { //출력
			System.out.print(count[i] + " ");
		}
	}

	public static void cal(int x, int[] ans, int point) {
		while (x > 0) {
			ans[x % 10] += point;
			x /= 10;
		}
	}
}
