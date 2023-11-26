import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static List<Integer>[] list;
    static int[] parent;
    static int[] score;
    static int[] cards;
    static int[] depth;
    static int[] sz;
    static int[] visit;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        sz = new int[n + 1];
        visit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        System.out.println(count - (long) n * (n - 1) / 2);

    }

    private static void dfs(int cur) {
        visit[cur] = 1;
        sz[cur] = 1;
        for (int i = 0; i < list[cur].size(); i++) {
            if (visit[list[cur].get(i)] == 1) {
                continue;
            }
            dfs(list[cur].get(i));
            sz[cur] += sz[list[cur].get(i)];
        }
        count += (long) n * (n - 1) / 2 - (long) (n - sz[cur]) * (n - sz[cur] - 1) / 2;
    }


}