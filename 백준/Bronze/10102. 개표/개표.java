import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		int count = 0;

		for (char result : str.toCharArray()) {
			if (result == 'A') {
				count++;
			}
		}

		String ret = "Tie";
		if (count * 2 > N) {
			ret = "A";
		} else if (count * 2 < N) {
			ret = "B";
		}
		System.out.println(ret);
	}
}