import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new List[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b].add(a);
		}
		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			if (arr[i].size() == 0) {
				continue;
			}
			arr[i].sort(Integer::compareTo);
			count += arr[i].get(1) - arr[i].get(0);
			count += arr[i].get(arr[i].size() - 1) - arr[i].get(arr[i].size() - 2);
			for (int j = 1; j < arr[i].size() - 1; j++) {
				count += Math.min(arr[i].get(j) - arr[i].get(j - 1), arr[i].get(j + 1) - arr[i].get(j));
			}
		}
		System.out.println(count);

	}

}