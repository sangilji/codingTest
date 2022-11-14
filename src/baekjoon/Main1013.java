package baekjoon;

import java.util.Scanner;

public class Main1013 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			if (s.next().matches("(100+1+|01)+$")) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
