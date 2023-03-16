import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][2];
        int[][] dp = new int[n + 1][100001];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());

            }
            dp[i][arr[i][1]] = arr[i][0];
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 100001; j++) {
                if (j>=arr[i][1]){
                    dp[i][j] = Math.max(dp[i-1][j-arr[i][1]] + arr[i][0], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

            for (int j = 0; j < 100001; j++) {
                if (dp[n][j] >= m){
                    System.out.println(j);
                    return;
            }
        }
    }
}