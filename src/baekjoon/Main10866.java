package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main10866 {
	public static void main(String[] args) throws IOException {
		Deque<Integer> dq = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			if (command.equals("front")) {
				if (dq.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(dq.getFirst());
			} else if (command.equals("back")) {
				if (dq.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(dq.getLast());
			} else if (command.equals("size")) {
				System.out.println(dq.size());
			} else if (command.equals("empty")) {
				if (dq.isEmpty()) {
					System.out.println(1);

				} else {
					System.out.println(0);
				}
			} else if (command.equals("pop_front")) {
				if (dq.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(dq.pollFirst());
			} else if (command.equals("pop_back")) {
				if (dq.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(dq.pollLast());
			} else {
				if (command.contains("front")) {
					dq.addFirst(Integer.parseInt(command.split(" ")[1]));
				} else {
					dq.addLast(Integer.parseInt(command.split(" ")[1]));
				}
			}
		}
	}
}
