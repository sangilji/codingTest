import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		int[] count = new int[10];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum = sum + arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j] == arr[i])
					count[i]++;
			}
		}
		int idx = 0;
		for (int i = 1; i < count.length; i++) {
			if(count[idx] < count[i]){
				idx = i;
			}
		}
		
		System.out.println(sum/10);
		System.out.println(arr[idx]);
		
	}
}