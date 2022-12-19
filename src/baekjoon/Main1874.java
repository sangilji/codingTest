package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main1874 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		int idx = 1;
		for (int i = 0; i < n; i++) {
			int tmp = s.nextInt();
			if (idx<=tmp) {
				while (idx <= tmp) {
					st.add(idx++);
					sb.append("+\n");
				}
			}
			else if(tmp != st.peek()){
				System.out.println("NO");
				return;
			}
			st.pop();
			sb.append("-\n");
		}
		System.out.println(sb);
	}
}
