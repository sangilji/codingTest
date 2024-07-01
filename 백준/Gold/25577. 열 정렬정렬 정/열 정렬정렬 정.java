import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int n;
    static int m;
    static int k;
    static int[][] arr;
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
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        visit = new int[n];
        for (int i = 0; i < n; i++) {
            if (visit[i] != 1) {
                count += dfs(i);
            }
        }
        System.out.println(count);
    }

    private static int dfs(int cur) {
        visit[cur] = 1;
        int tmp = 0;
        if (visit[arr[cur][1]] != 1) {
            tmp+=dfs(arr[cur][1])+1;
        }
        return tmp;
    }


}