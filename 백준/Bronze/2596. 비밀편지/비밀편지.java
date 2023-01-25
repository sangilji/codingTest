import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] tmp = {"000000","001111","010011","011100","100110","101001","110101","111010"};
	static String[] alphabet = {"A","B","C","D","E","F","G","H"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String a = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n;i++) {
			String t = check(a.substring(i*6,i*6+6));
			
			if(t.equals("fail")) {
				System.out.println(i+1);
				return;
			} else {
				sb.append(t);
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	public static String check(String a) {
		for (int i = 0; i < tmp.length; i++) {
			int count = 0;
			for (int j = 0; j < 6; j++) {
				if(tmp[i].charAt(j)!=a.charAt(j)) {
					count++;
				}
				if(count>=2) {
					break;
				}
			}
			if(count <=1) {
				return alphabet[i]; 
			}
		}
		return "fail";
	}
}