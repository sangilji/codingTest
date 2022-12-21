package baekjoon;

import java.util.Scanner;

public class Main15829 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String a = s.next();
		long result = 0;
		long pow =1;
		for (int i = 0; i < n; i++) {
			int tmp = a.charAt(i) - 'a' + 1;
			result+= tmp*pow;
			pow = (pow*31)%1234567891;
		}
		System.out.println(result % 1234567891);
	}
}
