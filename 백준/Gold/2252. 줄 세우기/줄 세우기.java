import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] degree = new int[n + 1];
		List<List<Integer>> arr = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			arr.get(a).add(b);
			degree[b]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < n + 1; i++) {
			if (degree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int tmp = q.poll();
			System.out.print(tmp +" ");

			for(int i : arr.get(tmp)){
				degree[i]--;
				if(degree[i] ==0){
					q.add(i);
				}
			}
		}
	}
}
