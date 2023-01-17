import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		int t = s.nextInt();
		for(int i =0; i< t;i++){
			String str = s.next();
			check(str);
		}
	}

	private static void check(String str) {
		int count = 0;
		for(char c : str.toCharArray()){
			if(c == '('){
				count++;
			} else {
				count --;
			}
			if(count<0){
				System.out.println("NO");
				return;
			}
		}
		if(count==0){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
		return;
	}
}
