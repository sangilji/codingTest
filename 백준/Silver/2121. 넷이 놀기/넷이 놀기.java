import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;

	static long count = 0;



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(arr,(o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		List<Integer> x = new ArrayList<>();
		List<int[]> y = new ArrayList<>();
		x.add(arr[0][0]);
		y.add(new int[2]);
		int index = 0;
		y.get(0)[0]=0;
		for (int i = 1; i < n; i++) {
			if (x.get(index) == arr[i][0]) {
				continue;
			}
			y.get(index)[1] = i - 1;
			x.add(arr[i][0]);
			y.add(new int[]{i,i});
			index++;
		}
		y.get(index)[1]=n-1;

		int start = 0;
		int end = 1;
		int count = 0;
		while (end < x.size()) {
			int tmp = x.get(end) - x.get(start);
			if (tmp < height) {
				end++;
			} else if (tmp > height) {
				start++;
			} else {
				int l = y.get(start)[0];
				int startr = y.get(start)[1];
				int r = l+1;
				while (r <= startr) {
					int tmp1 = arr[r][1] - arr[l][1];
					if (tmp1 < width) {
						r++;
					} else if (tmp1 > width) {
						l++;
					} else {
						if (find(arr,y.get(end), arr[r][1], arr[l][1])) {
							count++;
						}
						r++;
						l++;
					}
				}
				start++;
				end++;
			}
		}
		System.out.println(count);
	}

	private static boolean find(int[][] arr,int[] size, int a, int b) {
		int start = size[0];
		int last = size[1];
		boolean check = false;
		while (start <= last) {
			int mid = (start + last) >> 1;
			if (arr[mid][1] == a) {
				check = true;
				break;
			} else if (arr[mid][1] < a) {
				start = mid +1;
			}else{
				last = mid -1;
			}
		}
		if (!check) {
			return false;
		}
		start = size[0];
		last = size[1];
		while (start <= last) {
			int mid = (start + last) >> 1;
			if (arr[mid][1] == b) {
				return true;
			} else if (arr[mid][1] < b) {
				start = mid +1;
			}else{
				last = mid -1;
			}
		}
		return false;
	}

}