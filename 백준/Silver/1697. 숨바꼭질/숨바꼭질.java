import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] dp;
    static List<Integer>[] list;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        visit[n] = 0;
        q.add(n);
        while (!q.isEmpty()) {
            int tmp = q.poll();

            if (tmp == m) {
                System.out.println(visit[tmp]);
                return;
            }
            if (tmp - 1 >= 0 && visit[tmp - 1] == -1) {
                visit[tmp - 1] = visit[tmp] + 1;
                q.add(tmp - 1);
            }
            if (tmp + 1 <= 100000 && visit[tmp + 1] == -1) {
                visit[tmp + 1] = visit[tmp] + 1;
                q.add(tmp + 1);
            }
            if (tmp * 2 <= 100000 && visit[tmp * 2] == -1) {
                visit[tmp * 2] = visit[tmp] + 1;
                q.add(tmp * 2);
            }
        }
    }


}