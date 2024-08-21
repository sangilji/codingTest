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


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int sum =0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            max = Math.max(max, map.get(i));
        }
        for (int i : map.keySet()) {
            if (map.get(i) == max) {
                list.add(i);
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        Arrays.sort(arr);
        sb.append(Math.round((float) sum /n)).append("\n");
        sb.append(arr[n / 2]).append("\n");
        if (list.size() > 1) {
            sb.append(list.get(1)).append("\n");
        }else{
            sb.append(list.get(0)).append("\n");
        }
        sb.append(arr[n-1]-arr[0]).append("\n");
        System.out.println(sb);
    }



}