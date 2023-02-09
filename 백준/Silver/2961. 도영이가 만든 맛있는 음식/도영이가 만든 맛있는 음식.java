import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] taste;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        taste = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }


        dfs(0, 0, 1);
        System.out.println(min);

    }

    private static void dfs(int index, int sum, int mul) {

        if (index == n) {
            if (sum != 0) {
                min = Math.min(min, Math.abs(sum - mul));
            }
            return;
        }

        dfs(index + 1, sum, mul);
        dfs(index + 1, sum + taste[index][1], mul * taste[index][0]);

    }

}

