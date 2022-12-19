package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main10845 {
	public static void main(String[] args) throws IOException {
		Deque<Integer> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			if (command.equals("front")) {
				if (q.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(q.getFirst());
				}
			} else if (command.equals("back")) {
				if (q.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(q.getLast());
				}
			} else if (command.equals("size")) {
				System.out.println(q.size());
			} else if (command.equals("pop")) {
				if (q.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(q.pollFirst());
				}
			} else if (command.equals("empty")) {
				if (q.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else {
				q.add(Integer.parseInt(command.split(" ")[1]));
			}
		}
	}
}
