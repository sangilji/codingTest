import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr,ans;
	public static int N, M;
	public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static LinkedHashSet<String> set;
	public static void main(String[] args) throws IOException{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		ans = new int[N];
		set = new LinkedHashSet<>();
		st = new StringTokenizer(br.readLine());
        visit = new boolean[N];
        
        for(int i = 0; i < N; i++) {
        	ans[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(ans);
		dfs(0, 0);
		set.forEach(System.out::println);
	}
 
	public static void dfs(int depth, int t) {
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int val : arr) {
				sb.append(val + " ");
			}
			set.add(sb.toString());
			sb.append('\n');
			return;
		}
		for(int i = t; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = ans[i];
				dfs(depth+1, i+1);
				visit[i] = false;
			}
		}
	}
}