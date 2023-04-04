import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] count1;
    static int[] count2;
    static List<Integer>[] nodes1;
    static List<Integer>[] nodes2;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            nodes1 = new List[n + 1];
            nodes2 = new List[n + 1];
            for (int j = 0; j < nodes1.length; j++) {
                nodes1[j] = new ArrayList<>();
                nodes2[j] = new ArrayList<>();
            }
            count1 = new int[n + 1];
            count2 = new int[n + 1];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes1[a].add(b);
                nodes2[b].add(a);
            }
            int result = 0;
            for (int j = 1; j < n + 1; j++) {
                count1[j] = bfs1(j);
                count2[j] = bfs2(j);
                if (count1[j] + count2[j] + 1 == n) {
                    result++;
                }
            }

        System.out.println(result);
    }

    private static int bfs1(int current) {
        Queue<Integer> q = new ArrayDeque<>();
        visit = new boolean[n + 1];
        q.add(current);
        visit[current] = true;
        int sum = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (Integer i : nodes1[tmp]) {
                if (!visit[i]) {
                    visit[i] = true;
                    q.add(i);
                    sum++;
                }
            }
        }
        return sum;
    }
    private static int bfs2(int current) {
        Queue<Integer> q = new ArrayDeque<>();
        visit = new boolean[n + 1];
        q.add(current);
        visit[current] = true;
        int sum = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (Integer i : nodes2[tmp]) {
                if (!visit[i]) {
                    visit[i] = true;
                    q.add(i);
                    sum++;
                }
            }
        }
        return sum;
    }
}