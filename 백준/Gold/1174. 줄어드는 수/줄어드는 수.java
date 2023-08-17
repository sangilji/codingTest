import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	static int n;
	static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	static Set<Long> list = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		dfs(0, 0);
		List<Long> sortList = list.stream().sorted().collect(Collectors.toList());
		try {
			System.out.println(sortList.get(n - 1));
		} catch (Exception e) {
			System.out.println(-1);
		}
	}

	private static void dfs(long num, int index) {
		list.add(num);

		if (index >= 10) {
			return;
		}

		dfs(num * 10 + arr[index], index + 1);
		dfs(num, index + 1);
	}

}