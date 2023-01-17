import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int answer=0;
		for(int i =0; i<5;i++){
			answer += Math.pow(s.nextInt(),2);
		}
		System.out.println(answer%10);
	}
}
