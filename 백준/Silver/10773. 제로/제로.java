import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		long sum = 0;
		Stack<Long> st = new Stack<>();
		for (int i = 0; i < k; i++) {
			long n = s.nextLong();
			if (n == 0) {
				sum -= st.pop();
			} else {
				sum += n;
				st.add(n);
			}
		}
		System.out.println(sum);
	}
}
