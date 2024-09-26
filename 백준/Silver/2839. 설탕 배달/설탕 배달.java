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
    static Set<Integer> s = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int min = INF;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= 1000; i++) {
            int current = n - i * 5;
            if (current == 0) {
                min = Math.min(min, i);
                continue;
            }
            if (current < 0) {
                break;
            }
            if (current % 3 == 0) {
                min = Math.min(min, i + current / 3);
            }
        }
        if (min == INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);


    }


}