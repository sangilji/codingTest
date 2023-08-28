import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<int[]> arr = new ArrayList<>();
		int max = -1;
		for (int i = 0; i < n; i++) {
			int[] tmp = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			max = Math.max(max, tmp[1]);
			arr.add(tmp);
		}
		if (n == 1) {
			System.out.println(max);
			return;
		}
		arr.sort(Comparator.comparing(o -> o[0]));
		int height = 0;
		int sum = 0;
		int left = -1;
		for (int i = 0; i < n-1; i++) {
			int[] a = arr.get(i);
			if (a[1] == max) {
				left = a[0];
				break;
			}
			int[] b = arr.get(i + 1);
			height = Math.max(a[1], height);
			sum += (b[0] - a[0]) * height;
			if (b[1] == max) {
				left = b[0];
				break;
			}
		}
		int right = -1;
		height = 0;
		for (int i = n-1; i > 0; i--) {
			int[] a = arr.get(i);
			if (a[1] == max) {
				right = a[0];
				break;
			}
			int[] b = arr.get(i - 1);
			height = Math.max(a[1], height);
			sum += (a[0] - b[0]) * height;
			if (b[1] == max) {
				right = b[0];
				break;
			}
		}
		System.out.println(sum + (right - left + 1) * max);

	}




}