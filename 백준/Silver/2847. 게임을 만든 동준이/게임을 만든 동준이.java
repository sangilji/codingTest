import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 1_000_000_009;
	static int INF = 2_000_000_000;
	static int n;
	static int m;
	static int x;
	static int y;

	static int[] arr;
	static int[][] visit;
	static List<Integer> list = new ArrayList<>();
	static List<Integer>[] graph;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] >= arr[i + 1]) {
				count += arr[i] - (arr[i + 1] - 1);
				arr[i] = arr[i + 1] - 1;
			}
		}
		System.out.println(count);

	}

}