import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] arr2;
    static int[] costs;
    static int[] visit;
    static int[] visit2;
    static int[] sz;
    static int[] depth;
    static int[] parent;
    static int[] top;
    static int[] in;
    static int[] out;
    static long[] tree_min;
    static long[] tree_max;
    static List<Integer>[] list;
    static List<int[]>[] graph;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[][][][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            list = new List[n + 1];
            parent = new int[n + 1];
            arr = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                parent[j] = j;
            }
            for (int j = 0; j <= n; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j < n-1; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                arr[b]++;
            }
            int start = 0;
            for (int j = 1; j <=n; j++) {
                if (arr[j] == 0) {
                    start = j;
                }
            }
            dfs(start);
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            find(a,s1);
            find(b, s2);
            int result = 0;
            while (!s1.isEmpty() && !s2.isEmpty()) {
                int a1 = s1.pop();
                int a2 = s2.pop();
                if (a1 == a2) {
                    result = a1;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int a,Stack<Integer> s) {
        s.add(a);
        if (parent[a] == a) {
            return a;
        }
        return find(parent[a],s);
    }

    private static void dfs(int cur) {
        for (int i = 0; i < list[cur].size(); i++) {
            parent[list[cur].get(i)]= cur;
            dfs(list[cur].get(i));
        }
    }
}