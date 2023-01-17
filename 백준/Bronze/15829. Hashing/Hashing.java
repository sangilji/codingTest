import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String a = s.next();
		long result = 0;
		for (int i = 0; i < n; i++) {
			int tmp = a.charAt(i) - 'a' + 1;
			result = (long)((result + tmp * Math.pow(31, i))%1234567891);
		}
		System.out.println(result % 1234567891);
	}
}
