import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextInt();
		int result = 0;
		for (int i = 2; i <= n; i++) {
			int t = i;
			while (t >= 5) {
				if (t % 5 == 0) {
					t /= 5;
					result++;
				} else {
					break;
				}
			}
		}
		System.out.println(result);
	}
}
