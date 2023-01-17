import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			String x = s.next();
			if (x.equals("0")) {
				return;
			}
			if (check(x)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	private static boolean check(String x) {
		for (int i = 0; i < x.length() / 2; i++) {
			if (x.charAt(i) != x.charAt(x.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
