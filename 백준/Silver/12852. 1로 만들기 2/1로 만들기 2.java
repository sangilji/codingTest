import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static int min = Integer.MAX_VALUE;
    private static String tmp = "";

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dfs(n, 0, "");
        System.out.println(min);
        System.out.println(tmp);
    }

    private static void dfs(int n, int count, String s) {
        if (count > min || n < 1) {
            return;
        }
        if (n == 1 && min > n) {
            min = Math.min(min, count);
            tmp = s + n;
            return;
        }
        if (n % 3 == 0) {
            dfs(n / 3, count + 1, s + n + " ");
        }
        if (n % 2 == 0) {
            dfs(n / 2, count + 1, s + n + " ");
        }
        dfs(n - 1, count + 1, s + n + " ");
    }


}
