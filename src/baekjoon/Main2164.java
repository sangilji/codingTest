package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2164 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		boolean b = false;
		while (q.size() != 1) {
			if(b){
				q.add(q.poll());
			}else{
				q.poll();
			}
			b = !b;
		}
		System.out.println(q.poll());
	}
}
