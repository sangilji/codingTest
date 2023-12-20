import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;
    static int n;
    static int m;
    static List<Integer>[] list;
    static int[] parent;
    static int[] score;
    static int[] cards;
    static int[][] arr;
    static int[][][] dp;
    static int[] sz;
    static int[] visit;
    static long count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        arr = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            visit = new int[n + 1];
            dfs(i, i, 1);
        }
        int a = 0;
        int b = 0;
        int min = INF;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                int tmp = 0;
                for (int k = 1; k <= n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    tmp += Math.min(arr[k][i], arr[k][j]) * 2;
                }
                if (min > tmp) {
                    a = i;
                    b = j;
                    min = tmp;
                }
            }
        }
        sb.append(Math.min(a, b)).append(" ").append(Math.max(a, b)).append(" ").append(min);
        System.out.println(sb);


    }

    private static void dfs(int start, int cur, int depth) {
        for (int i = 0; i < list[cur].size(); i++) {
            if (arr[start][list[cur].get(i)] <= depth) {
                continue;
            }
            arr[start][list[cur].get(i)] = depth;
            dfs(start, list[cur].get(i), depth + 1);
        }
    }


    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }


}