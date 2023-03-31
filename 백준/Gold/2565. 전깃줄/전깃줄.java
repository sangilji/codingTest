import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][2];
        dp = new int[501];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr,Comparator.comparingInt(o->o[0]));
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < arr[i][1]; j++) {

                dp[arr[i][1]] = Math.max(dp[arr[i][1]], dp[j] + 1);
            }
        }
        System.out.println(n-Arrays.stream(dp).max().getAsInt());

    }

}