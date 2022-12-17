package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1920 {
	public static void main(String[] args) {
		Set<Integer> arr = new HashSet<>();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int tmp = s.nextInt();
			arr.add(tmp);
		}
		int m = s.nextInt();
		for (int i = 0; i < m; i++) {
			int tmp = s.nextInt();
			int length = arr.size();
			arr.add(tmp);
			if (length == arr.size()) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
