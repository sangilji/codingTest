import java.util.Scanner;

public class Main {
	private static long result = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int r = s.nextInt();
		int c = s.nextInt();
		find((int)Math.pow(2, n), r, c);
		System.out.println(result);
	}

	private static void find(long size, long r, long c) {
		if (size == 1) {
			return;
		} else if (size / 2 > r && size / 2 > c) {
			find(size / 2, r, c);
		} else if (size / 2 <= r && size / 2 > c) {
			result += size * size / 2;
			find(size / 2, r - size / 2, c);
		} else if (size / 2 > r && size / 2 <= c) {
			result += size * size / 4;
			find(size / 2, r, c - size / 2);
		} else {
			result += size * size * 3 / 4;
			find(size / 2, r - size / 2, c - size / 2);
		}
	}
}
