import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
        n = Integer.parseInt(br.readLine());

        sz = new int[n + 1];
        arr = new int[n * n][3];
        int[][] arr2 = new int[n + 1][n + 1];
        parent = new int[n + 1];
        visit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int index = 0;
        for (int i = 1; i <= n; i++) {
            arr[index][0] = 0;
            arr[index][1] = i;
            int tmp = Integer.parseInt(br.readLine());
            arr[index++][2] = tmp;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                arr[index][0] = i;
                arr[index][1] = j;
                arr[index++][2] = arr2[i][j];
            }
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[2]));
        int count = 0;
        boolean one = false;
        for (int i = 0; i < arr.length; i++) {
            int a = find(arr[i][0]);
            int b = find(arr[i][1]);
            if (a != b) {
                if (a < b) {
                    parent[b] = a;
                } else {
                    parent[a] = b;

                }

                count += arr[i][2];
            }
        }
        System.out.println(count);
    }


    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }


}