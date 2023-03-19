import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static boolean[] visit;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());
            result = 0;
            parent = new int[n + 1];
            visit = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                parent[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j < n + 1; j++) {
                if (!visit[j]) {
                    check(j);
                }
                result += q.size();
                q.clear();
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }

    static int result;
    static int num;

    private static void check(int j) {
        q.add(j);
        if (!visit[parent[j]]) {
            visit[j] = true;

            check(parent[j]);
        } else {
            visit[j] = true;
            num = parent[j];
            return;
        }

        if (num == j) {
            q.clear();
            num = -1;
            return;
        }

        if (num == -1) {
            result++;
        }

    }
}