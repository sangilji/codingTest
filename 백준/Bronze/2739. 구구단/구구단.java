import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int a;
		a = sc.nextInt();
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d %n", a , i, (a*i));
		}

		
	}
}