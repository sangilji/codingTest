import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	static int MOD = 1_000_000_007;

	static int n;
	static int m;
	static List<Integer>[] nodes;
	static Map<Long, Integer> map = new HashMap<>();
	static int[] in;
	static int[] out;
	static long[] arr;
	static long[] tree;
	static long[] tree1;
	static long[] lazy;
	static int SIZE = 150_000;
	static String s;
	static int count = 0;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// StringTokenizer st = new StringTokenizer(br.readLine());

		String t = br.readLine();
		dfs(t);
		System.out.println(count);
	}
	//1 10 100
	// 0 00 100
	// 0 10 100
	private static void dfs(String n) {
		int size = n.length();
		if (size==1) {
			count++;
			return;
		}
		if (Arrays.stream(n.split("")).distinct().count() == 1) {
			count++;
			return;
		}
		dfs(n.substring(1));
		dfs(n.substring(0,size-1));


	}

}