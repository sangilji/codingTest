import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000_009;
	static int n;
	static int m;
	static List<Long> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 100_000;
	static long[] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		int[] arr3 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < B; j++) {
				int a = arr[i];
				int b = arr2[j];
				int start = 0;
				int end = C - 1;
				while (start <= end) {
					int mid = (start + end) >> 1;
					int c = arr3[mid];
					int min = Math.min(a, Math.min(b, c));
					int max = Math.max(a, Math.max(b, c));
					int tmp = max - min;
					if (tmp < result) {
						result = tmp;
					}
					if (max == c) {
						end = mid - 1;
					} else {
						start = mid + 1;
					}
				}
			}
		}
		System.out.println(result);

	}

}