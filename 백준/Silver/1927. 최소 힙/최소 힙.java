import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(o -> o));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int c = s.nextInt();
			if (c == 0) {
				if (q.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(q.poll()).append("\n");
				}
			} else {
				q.add(c);
			}
		}
		System.out.println(sb);
	}
}
