import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int n;
    static int r;
    static int m;
    static int k;
    static int x;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer>[] list;

    static int count = 0;
    static int[] arr2;
    static int[][] dp;
    static int[] visit = new int[n + 1];

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
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] visit = new int[100001];
        Arrays.fill(visit, INF);
        visit[n] = 0;
        q.add(new int[]{n, 0});
        int count = INF;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == m) {
                System.out.println(tmp[1]);
                count = tmp[1];
                break;
            }
            if (tmp[0] - 1 >= 0 && visit[tmp[0] - 1] > tmp[1] + 1) {
                visit[tmp[0] - 1] = tmp[1] + 1;
                q.add(new int[]{tmp[0] - 1, tmp[1] + 1});
            }
            if (tmp[0] + 1 <= 100000 && visit[tmp[0] + 1] > tmp[1] + 1) {
                visit[tmp[0] + 1] = tmp[1] + 1;
                q.add(new int[]{tmp[0] + 1, tmp[1] + 1});
            }
            if (tmp[0] * 2 <= 100000 && visit[tmp[0] * 2] > tmp[1] + 1) {
                visit[tmp[0] * 2] = tmp[1] + 1;
                q.add(new int[]{tmp[0] * 2, tmp[1] + 1});
            }
        }
        int result = m;
        StringBuilder sb = new StringBuilder();
        count--;
        Stack<Integer> s = new Stack<>();
        s.push(result);

        while (result != n) {
            if (result - 1 >= 0 && visit[result - 1] == count) {
                s.push(result - 1);
                result -= 1;
                count--;
                continue;
            }
            if (result + 1 <= 100000 && visit[result + 1] == count) {
                s.push(result + 1);
                result += 1;
                count--;
                continue;
            }
            if (result % 2 == 0 && visit[result / 2] == count) {
                s.push(result / 2);
                result /= 2;
                count--;
            }
        }
        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb);
    }


}