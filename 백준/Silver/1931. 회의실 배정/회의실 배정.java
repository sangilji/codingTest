import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static long[][] list;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		list = new long[n][2];
		for (int i = 0; i < n; i ++){
			int a = s.nextInt();
			int b = s.nextInt();
			list[i][0] = a;
			list[i][1] = b;
		}
		Arrays.sort(list,(o1, o2) -> {
			if(o1[1] == o2[1]){
				return (int)(o1[0] - o2[0]);
			}
			return (int)(o1[1] - o2[1]);
		});
		long tmp = list[0][1];
		int result = 1;
		for (int i =1; i < n ; i++){
			if(list[i][0] >= tmp){
				result++;
				tmp = list[i][1];
			}
		}
		System.out.println(result);
	}

}
