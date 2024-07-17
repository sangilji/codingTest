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
    static long[] tree_min;
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
        char[] tmp = br.readLine().toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            if ('a' <= tmp[i] && tmp[i] <= 'z') {
                int a = tmp[i] - 'a';
                a+=13;
                a %= 26;
                tmp[i] = (char) ('a' + a);
            }else if ('A'<= tmp[i] && tmp[i] <= 'Z'){
                int a = tmp[i] - 'A';
                a+=13;
                a %= 26;
                tmp[i] = (char) ('A' + a);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : tmp) {
            sb.append(c);
        }
        System.out.println(sb);
    }


}