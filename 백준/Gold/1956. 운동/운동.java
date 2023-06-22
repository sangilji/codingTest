import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int v;
    static int e;
    static final int INF = 987654321;
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int[][] arr = new int[v + 1][v + 1];
        for (int i = 1; i < v + 1; i++) {
            Arrays.fill(arr[i], INF);
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[a][b] = cost;
        }

        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k < v + 1; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (arr[j][k] > arr[j][i] + arr[i][k]) {
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (arr[i][j] != INF && arr[j][i] != INF) {
                    max = Math.min(max, arr[i][j] + arr[j][i]);
                }
            }
        }
        if (max==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(max);
    }


}