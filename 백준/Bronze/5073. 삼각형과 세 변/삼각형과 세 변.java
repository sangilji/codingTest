import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			//A, B, C가 모두 0이면 종료
			if(A == 0 && B == 0 && C == 0) break;
			
			//삼각형 조건을 만족하지 못하는 경우
			int MAX = Math.max(Math.max(A, B), C);
			
			if(MAX == A) {
				int sum = B + C;
				
				if(A >= sum) {
					System.out.println("Invalid");
					continue;
				}
			}
			
			if(MAX == B) {
				int sum = A + C;
				
				if(B >= sum) {
					System.out.println("Invalid");
					continue;
				}
			}
			
			if(MAX == C) {
				int sum = A + B;
				
				if(C >= sum) {
					System.out.println("Invalid");
					continue;
				}
			}
			
			//세 수가 모두 다를 경우
			if(A != B && A != C && B != C) {
				System.out.println("Scalene");
				continue;
			}
			
			//A, B, C가 모두 같으면
			if(A == B && A == C && B == C) {
				System.out.println("Equilateral");
				continue;
			}
			
			//2개의 수만 같을 경우
			if(A == B || A == C || B == C) {
				System.out.println("Isosceles");
				continue;
			}
		}
	}
}