import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 T

		int sum = 0;
		for (int i = 0; i < T; i++) {
			String AB = br.readLine();
			String[] arr = AB.split(",");

			for (int j = 0; j < arr.length; j++) {
				sum += Integer.parseInt(arr[j]);
			}
			System.out.println(sum);
			sum = 0;// 한번 더하고 나면 0으로 초기화 해주기
		}
	}
}