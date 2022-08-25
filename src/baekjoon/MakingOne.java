package baekjoon;

import java.util.Scanner;

public class MakingOne {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] dp = new int[1000001];
        dp[2]=1;
        dp[3]=1;
        for(int i =4;i<=n;i++){
            dp[i]= dp[i-1]+1;
            if(i%3==0){
                dp[i]=Math.min(dp[i/3]+1,dp[i]);
            }
            if(i%2==0){
                dp[i]=Math.min(dp[i/2]+1,dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
