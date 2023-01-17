
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    final static int mod = 1000000000;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] dp = new int[n+1][10];
        for(int i =1;i<10;i++) {
            dp[1][i]=1;
        }
        for(int i =2;i<=n;i++){
            for(int j =0;j<=9;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][1]%mod;
                } else if(j==9){
                    dp[i][j]=dp[i-1][8]%mod;
                } else {
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%mod;
                }

            }
        }
        for(int i =1;i<=9;i++){
            dp[n][0]=(dp[n][0]+dp[n][i])%mod;
        }
        System.out.println(dp[n][0]);
    }
}
