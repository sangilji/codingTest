package baekjoon;

import java.util.Scanner;

public class Main1717 {
	private static int[] parent;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		parent = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
		}
		int m = s.nextInt();

		for (int i = 0; i < m; i++) {
			int command = s.nextInt();
			if (command == 0) {
				int a = s.nextInt();
				int b = s.nextInt();
				a = find(a);
				b = find(b);
				if (a < b) {
					parent[b] = a;
				} else {
					parent[a] = b;
				}
			} else {
				int a = s.nextInt();
				int b = s.nextInt();
				a = find(a);
				b = find(b);
				if (a == b) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}

		}
		for (int i : parent) {
			System.out.println(i);
		}
	}

	private static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
}
