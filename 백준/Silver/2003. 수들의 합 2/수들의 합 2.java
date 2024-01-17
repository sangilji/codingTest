import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;

    static int[] arr;
    static long[] tree;
    static List<int[]>[] list;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};

    static long count = 0;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int start = 0;
        int end = 0;
        int sum = arr[0];

        while (end < n) {

            if (sum < m) {
                end++;
                sum += arr[end];
            } else if (sum > m) {
                sum -= arr[start];
                start++;
            } else {
                count++;
                end++;
                sum += arr[end];
                sum -= arr[start];
                start++;
            }
        }
        System.out.println(count);

    }

}