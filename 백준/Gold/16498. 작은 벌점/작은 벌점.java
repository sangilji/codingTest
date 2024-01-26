import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] arr2;
    static int[] costs;
    static int[] visit;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] A = new int[a];
        int[] B = new int[b];
        int[] C = new int[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(C);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                int start = 0;
                int end = c - 1;
                while (start <= end) {
                    int mid = (start + end) >> 1;
                    int max = Math.max(A[i], Math.max(B[j], C[mid]));
                    int min = Math.min(A[i], Math.min(B[j], C[mid]));
                    result = Math.min(result, max - min);
                    if (C[mid] == min) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
        System.out.println(result);

    }


}