import java.util.Scanner;
import java.util.Arrays;
public class Main {
 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int arr[] = {in.nextInt(), in.nextInt(), in.nextInt()};
		in.close();		
        
		Arrays.sort(arr);	//정렬 메소드 (기본이 오름차순이다.)
        
		System.out.println(arr[1]);
	}
}