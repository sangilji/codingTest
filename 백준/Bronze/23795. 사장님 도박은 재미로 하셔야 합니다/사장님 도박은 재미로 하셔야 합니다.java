import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int r;
    static int m;
    static int c;
    static int x;
    static int[] arr;
    static long[] tree;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]>[] list;

    static long count = 0;
    static int[] arr2;
    static int[][] dp;
    static long[] visit;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }
            count += n;
        }
        System.out.println(count);

    }


}