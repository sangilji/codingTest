import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long m;
	static int[] depthMin = new int[100];
	static int[] depthMax = new int[100];
	static List<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new List[n + 1];
		Arrays.fill(depthMin, 1000000);
		for (int i = 0; i < n + 1; i++) {
			arr[i] = new ArrayList<>();
		}
		int[] find = new int[n + 1];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (b != -1) {
				find[b]++;
			}
			if (c != -1) {
				find[c]++;
			}
			arr[a].add(b);
			arr[a].add(c);
		}
		int first = 1;
		// System.out.println(Arrays.toString(find));
		for (int i = 1; i < n+1; i++) {
			if (find[i]==0){
				first = i;
				break;
			}
		}
		dfs(first, 1);
		int idx = 0;
		int max = 0;
		for (int i = 0; i < depthMax.length; i++) {
			if (max<(depthMax[i] - depthMin[i]+1)){
				idx = i;
				max = (depthMax[i] - depthMin[i]+1);
			}
		}
		System.out.println(idx +" " + max);
	}
	static int num = 1;
	private static void dfs(int current, int depth) {
		int left = arr[current].get(0);
		int right = arr[current].get(1);
		if (left != -1) {
			dfs(left,depth+1);
		}
		depthMax[depth] = Math.max(depthMax[depth], num);
		depthMin[depth] = Math.min(depthMin[depth], num);
		num++;
		if (right != -1) {
			dfs(right,depth+1);
		}
	}

}