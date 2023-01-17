import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println(bfs(a, b));
        }
    }

    private static String bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[10000];
        String[] answer = new String[10000];
        int D = d(a);
        int S = s(a);
        int L = l(a);
        int R = r(a);
        q.add(D);
        answer[D] = "D";
        visit[D] = true;
        q.add(S);
        answer[S] = "S";
        visit[S] = true;
        q.add(L);
        answer[L] = "L";
        visit[L] = true;
        q.add(R);
        answer[R] = "R";
        visit[R] = true;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (tmp == b) {
                return answer[b];
            }
            D = d(tmp);
            S = s(tmp);
            L = l(tmp);
            R = r(tmp);
            if (!visit[D]) {
                q.add(D);
                answer[D] = answer[tmp] + "D";
                visit[D] = true;
            }
            if (!visit[S]) {
                q.add(S);
                answer[S] = answer[tmp] + "S";
                visit[S] = true;
            }
            if (!visit[L]) {
                q.add(L);
                answer[L] = answer[tmp] + "L";
                visit[L] = true;
            }
            if (!visit[R]) {
                q.add(R);
                answer[R] = answer[tmp] + "R";
                visit[R] = true;
            }
        }
        return "";
    }

    private static int d(int n) {
        return n * 2 % 10000;
    }

    private static int s(int n) {
        if (n == 0) {
            return 9999;
        }
        return n - 1;
    }

    private static int l(int n) {
        return (n % 1000) * 10 + n / 1000;
    }

    private static int r(int n) {
        return (n % 10) * 1000 + n / 10;
    }
}
