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
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        sz = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sz[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int findA = find(a);
            int findB = find(b);
            if (findA != findB) {
                if (findA < findB) {
                    sz[findA] = Math.min(sz[findA], sz[findB]);
                    sz[findB] = 0;
                    parent[findB] = findA;
                } else {
                    sz[findB] = Math.min(sz[findA], sz[findB]);
                    sz[findA] = 0;
                    parent[findA] = findB;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += sz[i];
        }
        if (sum <= k) {
            System.out.println(sum);
        } else {
            System.out.println("Oh no");
        }

    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }


}