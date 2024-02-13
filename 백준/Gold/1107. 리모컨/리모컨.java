import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr1;
    static int count = INF;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<Integer> list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[10];
        if (m != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[tmp] = 1;
            }
        }
        if (n == 100) {
            System.out.println(0);
            return;
        }
        int answer = Math.abs(n - 100);

        for (int i = 0; i < 1000000; i++) {
            if (check(String.valueOf(i))) {
                int tmp = Math.abs(n - i) + String.valueOf(i).length();
                answer = Math.min(answer, tmp);
            }
        }
        System.out.println(answer);
    }

    private static boolean check(String i) {
        for (char c : i.toCharArray()) {
            if (arr[c - '0'] == 1) {
                return false;
            }
        }
        return true;
    }


}