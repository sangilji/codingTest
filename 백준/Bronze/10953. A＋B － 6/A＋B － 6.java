import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 개수 T

		int sum = 0;
		for (int i = 0; i < T; i++) {
			String AB = sc.next();
			String[] arr = AB.split(",");

			for (int j = 0; j < arr.length; j++) {
				sum += Integer.parseInt(arr[j]);
			}
			System.out.println(sum);
			sum = 0;// 한번 더하고 나면 0으로 초기화 해주기
		}
		sc.close();
	}
}