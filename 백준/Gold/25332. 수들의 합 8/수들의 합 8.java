import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000_007;
	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Long, Integer> map = new HashMap<>();
	static long[] arr;
	static long[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 150_000;
	static String s;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new long[n + 1];
		arr2 = new long[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		long[] arr3 = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			arr3[i] = arr3[i-1] + arr2[i] - arr[i];
		}

		long count = 0;
		for (int i = 1; i <= n; i++) {
			if (arr3[i]==0) count++;
			int tmp = map.getOrDefault(arr3[i],0);
			count+= tmp;
			map.put(arr3[i], tmp + 1);

		}

		System.out.println(count);


	}
/*
3
3 1 2
2 1 4
 */


}