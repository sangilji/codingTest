import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			//총학점 저장 할 변수
			int Csum = 0;
			//학점 평균을 구하기위한 변수 소수이기때문에 double형으로 선언
			double Gave = 0;
			
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				double G = Double.parseDouble(st.nextToken());
				
				Csum += C;
				Gave += (G * C);
			}
			//총합과 학점 평균을 출력(학점 평균은 모든 과목의 (학점 * 점수)를 구한 Gave에 총 학점인 Csum을 나눠준다.
			System.out.println(Csum + " " + String.format("%.1f", (Gave / Csum)));
		}
	}

}