import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Set;

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
    static long[] sz;
    static int[] depth;
    static int[] parent;
    static int[] top;
    static int[] in;
    static int[] out;
    static int[] tree;
    static long[] tree_max;
    static List<Integer>[] list;
    static List<Integer>[] graph;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static long count = 0;
    static int[][] dp;
    static int[][] dp2;
    static StringBuilder sb = new StringBuilder();
    static Set<String> s = new LinkedHashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[21];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[tmp] = 1;
            } else if (command.equals("remove")) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[tmp] = 0;
            } else if (command.equals("check")) {
                int tmp = Integer.parseInt(st.nextToken());
                sb.append(arr[tmp]).append("\n");
            } else if (command.equals("toggle")) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[tmp] = arr[tmp] == 1 ? 0 : 1;
            } else if (command.equals("all")) {
                Arrays.fill(arr, 1);
            }else{
                Arrays.fill(arr, 0);
            }
        }
        System.out.println(sb);
    }


}