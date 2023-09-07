import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 150_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m + 2];
		for (int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				arr[m-tmp+1] +=1;
			}else{
				arr[1] += 1;
				arr[1+tmp] -=1;
			}
		}
		for (int i = 1; i <= m; i++) {
			arr[i] += arr[i - 1];
		}
		int min = 10000000;
		for (int i = 1; i <= m; i++) {
			min = Math.min(min, arr[i]);
		}
		int count = 0;
		for (int i = 1; i <=m; i++) {
			if (min == arr[i]) {
				count++;
			}
		}
		sb.append(min).append(" ").append(count);
		System.out.println(sb);

	}

}