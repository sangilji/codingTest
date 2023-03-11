import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < T; i++) {
            String[] temp = reader.readLine().split(" ");
            
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);
            
            System.out.println(combination(M, N));
        }
        
        reader.close();
    }
    
    private static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        } else if (n == r || r == 0) {
            return dp[n][r] = 1;
        } else {
            return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }
}