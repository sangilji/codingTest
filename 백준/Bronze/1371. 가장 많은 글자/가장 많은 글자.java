import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//EOF처리를 위한 입력값을 받을 문자열 input
		String input;
		//input에 저장된 문자열을 합치기위한 문자열 변수
		String S = "";
		
		//while의 조건문에 있는 것이 EOF에러 해결 방법이다.
		//null값이 오지 않을떄만 반복한다는 반복문
		while((input = br.readLine()) != null) {
			S += input;
		}
		
		//문자열에 저장된 알파벳 개수의 최댓값을 저장 할 변수
		int max = 0;
		//최갯값을 가지는 알파벳을 저장 할 문자열 변수
		String Smax = "";
		
		//소문자 알파벳 개수만큼 반복하는 반복문을 만든다.
		//i가 97 부터 122까지인 것은 아스키 코드 값으로 활용하기 위함인데
		//알파벳의 아스키코드 값이 97부터 122까지이다.
		for(char i = 97; i < 123; i++) {
			int count = S.length() - S.replace(String.valueOf(i), "").length();
			
			if(max == count) {
				Smax += String.valueOf(i);
			}
			
			if(max < count) {
				max = count;
				Smax = String.valueOf(i);
			}
		}
		System.out.println(Smax);
	}

}