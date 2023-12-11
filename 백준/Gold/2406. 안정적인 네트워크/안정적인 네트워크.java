import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n * n][3];
        int[][] arr2 = new int[n + 1][n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int index = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a = find(a);
            b = find(b);
            if (a != b) {
                if (a < b) {
                    parent[b] = a;
                } else {
                    parent[a] = b;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1 || i == j) {
                    continue;
                }
                arr[index][0] = i;
                arr[index][1] = j;
                arr[index++][2] = arr2[i][j];
            }
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[2]));
        int sum = 0;
        int count = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int a = find(arr[i][0]);
            int b = find(arr[i][1]);
            if (a != b) {
                if (a < b) {
                    parent[b] = a;
                } else {
                    parent[a] = b;

                }
                list.add(new int[]{arr[i][0], arr[i][1]});
                count++;
                sum += arr[i][2];
            }
        }
        sb.append(sum).append(" ").append(count).append("\n");
        for (int[] tmp : list) {
            sb.append(tmp[0]).append(" ").append(tmp[1]).append("\n");
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