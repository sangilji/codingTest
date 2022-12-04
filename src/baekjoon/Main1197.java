package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1197 {
	private static int[] parent;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();

		parent = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}
		int[][] nodes = new int[e][3];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i][0] = s.nextInt();
			nodes[i][1] = s.nextInt();
			nodes[i][2] = s.nextInt();
		}
		Arrays.sort(nodes, Comparator.comparingInt(o -> o[2]));
		int result = 0;
		for (int[] node : nodes) {
			int a = check(node[0]);
			int b = check(node[1]);

			if (a != b) {
				result += node[2];
				parent[b] = a;

			}
		}
		System.out.println(result);
	}

	private static int check(int i) {
		if (i == parent[i]) {
			return i;
		}
		return check(parent[i]);
	}
}
