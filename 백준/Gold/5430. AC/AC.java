import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String p = sc.next();
			int n = sc.nextInt();

			String arrStr = sc.next();
			Deque<Integer> deque = new LinkedList<>();
			for (String num : arrStr.substring(1, arrStr.length() - 1).split(","))
				if (!num.equals(""))
					deque.add(Integer.valueOf(num));

			System.out.println(ac(deque, p));
		}
	}

	static String ac(Deque<Integer> deque, String commands) {
		boolean reverse = false;

		for (char command : commands.toCharArray()) {
			if (command == 'R')
				reverse = !reverse;
			else {
				if (deque.size() == 0)
					return "error";

				if (reverse)
					deque.removeLast();
				else
					deque.removeFirst();
			}
		}

		StringBuilder sb = new StringBuilder("[");
		while (!deque.isEmpty()) {
			sb.append(reverse ? deque.removeLast() : deque.removeFirst());
			if (deque.size() != 0)
				sb.append(',');
		}
		sb.append(']');

		return sb.toString();
	}
}
