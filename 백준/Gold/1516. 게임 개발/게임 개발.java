import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;
    static int n;
    static int m;
    static List<int[]>[] list;
    static int[] parent;
    static int[] score;
    static int[] cards;
    static int[] arr;
    static int[][][] dp;
    static int[] sz;
    static int[] visit;
    static long count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        sz = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) {
                    break;
                }
                list[tmp].add(i);
                sz[i]++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (sz[i] == 0) {
                q.add(i);
                sz[i]--;
            }
        }
        int[] result = new int[n + 1];
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                int tmp = q.poll();
                for (int i = 0; i < list[tmp].size(); i++) {
                    sz[list[tmp].get(i)]--;
                    result[list[tmp].get(i)] = Math.max(arr[tmp] + result[tmp], result[list[tmp].get(i)]);
                }
            }
            for (int i = 1; i <= n; i++) {
                if (sz[i] == 0) {
                    q.add(i);
                    sz[i]--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(arr[i] + result[i]).append("\n");
        }
        System.out.println(sb);


    }


    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }


}