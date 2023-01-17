import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		List<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			arr.add(i);
		}
		int idx = 0;
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			idx = (idx + k) % arr.size() - 1;
			if(idx ==-1){
				idx = arr.size()-1;
			}
			result.add(String.valueOf(arr.remove(idx)));
		}
		System.out.printf("<%s>%n", String.join(", ", result));
	}
}
