import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean a = false;
		boolean b = false;
		int[] num = new int[8];
		for (int i = 0; i < 8; i++) {
			num[i] = s.nextInt();

		}
		for (int i = 0; i < 7; i++) {
			if (num[i] < num[i + 1]) {
				b = true;
			} else {
				a = true;
			}
		}
		if (a && b) {
			System.out.println("mixed");
		} else if(b){
			System.out.println("ascending");
		} else {
			System.out.println("descending");
		}
	}
}
