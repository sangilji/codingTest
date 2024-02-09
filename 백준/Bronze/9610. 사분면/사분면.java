import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int Q1 = 0, Q2 = 0, Q3 = 0, Q4 = 0, AXIS = 0;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//사분면에 해당하지 않음
			if(x == 0 || y == 0) {
				AXIS++;
			}else if(x > 0) {
				//1사분면
				if(y > 0) {
					Q1++;
				//4사분면
				}else {
					Q4++;
				}
			}else if(x < 0) {
				//2사분면
				if(y > 0) {
					Q2++;
				//3사분면
				}else {
					Q3++;
				}
			}
		}
		System.out.println("Q1: " + Q1);
		System.out.println("Q2: " + Q2);
		System.out.println("Q3: " + Q3);
		System.out.println("Q4: " + Q4);
		System.out.println("AXIS: " + AXIS);
	}

}