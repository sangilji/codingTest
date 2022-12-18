package baekjoon;

import java.util.Scanner;

public class Main2609 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int[] result = new int[2];
		for(int i = 1; i<= (Math.min(a, b)); i++){
			if(a%i==0 && b%i ==0){
				result[0]=i;
			}
		}
		for(int i = Math.min(a,b);; i+=Math.min(a,b)){
			if(i%a ==0 && i% b==0){
				result[1]=i;
				break;
			}
		}
		System.out.println(result[0]+"\n"+result[1]);
	}
}
