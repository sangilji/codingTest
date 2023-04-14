import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputData = br.readLine();
		
		for(int i = 0; i < inputData.length(); i++) {
			char c = inputData.charAt(i);
			
			if(Character.isUpperCase(c)) {
				System.out.print(String.valueOf(c).toLowerCase());
			} else {
				System.out.print(String.valueOf(c).toUpperCase());
			}
		}
	}

}