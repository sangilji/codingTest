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
    static long m;
    static int k;

    static long[] arr;
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

    static int count = 0;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        
        while (end >= 0) {
            if (arr[end] >= m) {
                end--;
                count++;
                n--;
            } else {
                break;
            }
        }
        while (start < end) {
            long mid = arr[start] + arr[end];
            if (mid * 2>= m) {
                count++;
                start++;
                end--;
                n -= 2;
            } else {
                start++;
            }
        }
        count += (n / 3);
        System.out.println(count);

    }


}