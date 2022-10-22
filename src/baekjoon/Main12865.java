package baekjoon;

import java.util.*;

public class Main12865 {
    static int[][] arr;
    static int n,k;
    static int result=0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        k = s.nextInt();
        arr = new int[n+1][2];
        int[] dp = new int[k+1];
        for(int i =1;i<=n;i++){
            arr[i][0]=s.nextInt();
            arr[i][1]=s.nextInt();
        }
        for(int i =0;i<=n;i++){
            for(int j =k;j-arr[i][0]>=0;j--){
                dp[j]=Math.max(dp[j],dp[j-arr[i][0]]+arr[i][1]);
                System.out.print(dp[j]);
            }
            System.out.println();
        }

        System.out.println(dp[k]);
    }

}
