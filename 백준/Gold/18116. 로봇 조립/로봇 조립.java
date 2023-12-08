import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
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
        n = 1000000;
        m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        sz = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            if (a.equals("I")) {
                int c = Integer.parseInt(st.nextToken());
                int findA = find(b);
                int findB = find(c);
                if (findA != findB) {
                    if (findA < findB) {
                        sz[findA] += sz[findB];
                        sz[findB] = 0;
                        parent[findB] = findA;

                    } else {
                        sz[findB] += sz[findA];
                        sz[findA] = 0;
                        parent[findA] = findB;
                    }
                }
            } else {
                int find = find(b);
                sb.append(sz[find]).append("\n");
            }

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