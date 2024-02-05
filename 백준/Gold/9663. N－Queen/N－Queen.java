import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] visit;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        recur(0);
        System.out.println(count);
    }

    private static void recur(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (check(depth)) {
                recur(depth + 1);
            }
        }
    }

    private static boolean check(int depth) {

        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i]) {
                return false;
            }
            if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;

    }


}