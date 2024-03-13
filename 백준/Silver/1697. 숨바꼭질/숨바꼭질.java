import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int sum;
    static int[] visit;
    static int[] price;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr1;
    static int count = 0;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<Integer> list;

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        visit = new int[100001];
        Arrays.fill(visit, -1);
        q.add(n);
        visit[n] = 0;

        while (!q.isEmpty()) {
            int tmp = q.poll();

            if (tmp == m) {
                System.out.println(visit[tmp]);
                return;
            }
            if (tmp * 2 <= 100000 && visit[tmp * 2] == -1) {
                visit[tmp * 2] = visit[tmp] + 1;
                q.add(tmp * 2);
            }
            if (tmp + 1 <= 100000 && visit[tmp + 1] == -1) {
                visit[tmp + 1] = visit[tmp] + 1;
                q.add(tmp + 1);
            }
            if (tmp - 1 >= 0 && visit[tmp - 1] == -1) {
                visit[tmp - 1] = visit[tmp] + 1;
                q.add(tmp - 1);
            }
        }
    }


}