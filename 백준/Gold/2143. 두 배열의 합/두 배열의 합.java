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

	static int MOD = 1_000_000;
	static int n;
	static int m;
	static List<int[]> list = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] arr1;
	static int[] arr2;
	static long[] tree;
	static long[] lazy;
	static int SIZE = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		arr1 = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		int[] a = new int[n * (n + 1) / 2];
		int[] b = new int[m * (m + 1) / 2];
		int index = 0;
		for (int i = 0; i < n; i++) {
			int sum = arr1[i];
			a[index++] = sum;
			for (int j = i+1; j < n; j++) {
				sum += arr1[j];
				a[index++] = sum;
			}
		}
		index = 0;
		for (int i = 0; i < m; i++) {
			int sum = arr2[i];
			b[index++] = sum;
			for (int j = i+1; j < m; j++) {
				sum += arr2[j];
				b[index++] = sum;
			}
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int start = 0;
		int end = b.length - 1;
		long result = 0;
		while (start < a.length && end >= 0) {
			int answer = a[start] + b[end];
			if (answer < k) {
				start++;
			} else if (answer > k) {
				end--;
			}else{
				int aCount =0;
				int bCount = 0;
				int left = a[start];
				int right = b[end];
				for (int i = start; i < a.length ; i++) {
					if (left == a[i]) {
						aCount++;
					}else{
						break;
					}
				}
				for (int i = end; i >=0 ; i--) {
					if (right == b[i]) {
						bCount++;
					}else{
						break;
					}
				}
				result+=(long)aCount*bCount;
				start+=aCount;
				end -= bCount;
			}
		}
		System.out.println(result);
	}

}