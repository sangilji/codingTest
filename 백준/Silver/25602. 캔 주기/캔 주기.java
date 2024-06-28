import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int n;
    static int m;
    static int k;
    static int[] arr;
    static int[][] arr2;
    static int[][] arr3;
    static int[] a;
    static int[] b;
    static int[] visit;
    static int[] dp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr2 = new int[m][n];
        arr3 = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr3[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0));
    }

    private static int dfs(int depth) {
        if (depth == m) {
            return 0;
        }
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] == 0 || arr[j] == 0) {
                    continue;
                }
                if (i == j) {
                    if (arr[i] < 2) {
                        continue;
                    }
                    arr[i] -= 2;
                    tmp = Math.max(tmp, dfs(depth + 1) + arr2[depth][i] + arr3[depth][i]);
                    arr[i] += 2;
                } else {
                    arr[i] -= 1;
                    arr[j] -= 1;
                    tmp = Math.max(tmp, dfs(depth + 1) + arr2[depth][i] + arr3[depth][j]);
                    arr[i] += 1;
                    arr[j] += 1;
                }
            }
        }
        return tmp;
    }


}