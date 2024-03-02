import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//최댓값을 저장할 변수
		int max = 0;
		//몇번째 사람인지 저장할 변수
		int n = 0;
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j = 0; j < 4; j++) {
				//sum에 입력되는 족족 합한다.
				sum += Integer.parseInt(st.nextToken());
			}
			//max가 sum보다 적으면 max에 sum값을 n에 i+1값을 저장한다.
			if(max < sum) {
				max = sum;
				n = i + 1;
			}
		}
		System.out.println(n + " " + max);
	}

}