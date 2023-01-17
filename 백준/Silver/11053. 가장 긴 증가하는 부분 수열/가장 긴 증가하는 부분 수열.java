
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        int result=0;

        for(int i =0;i<n;i++){
            a[i]=s.nextInt();
        }
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(a[i]>a[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            result = Math.max(result,dp[i]);
        }
        System.out.println(result);
    }
}
