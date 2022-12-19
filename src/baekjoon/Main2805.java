package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		long[] trees = new long[n];
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		long left = 1;
		long right = Arrays.stream(trees).max().getAsLong();
		long mid;
		while (left < right) {
			mid = (left + right) / 2;
			long count = 0;
			for (int i = 0; i < n; i++) {
				if (trees[i] > mid) {
					count += (trees[i] - mid);
				}
			}
			if (count < m) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left - 1);
	}
}
