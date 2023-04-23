import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int width = 3;
		int[] star = new int[16];
		for(int i=1; i<star.length; i++) {	// 1 ~ 15
			star[i] = width * width;
			width = width + (width-1);
		}
		
		System.out.println(star[N]);
		scan.close();
	}
}