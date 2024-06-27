import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int n;
    static int m;
    static int k;
    static int[] arr;
    static int[] visit;
    static int[] dp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new int[200001];
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < tmp.length; i++) {
            visit[tmp[i]] = 1;
        }
        for (int i = 1; i <= k; i++) {
            if (visit[i] != 1 && !recur(i)) {
                count += 1;
            }
        }
        if (count > 0) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    private static boolean recur(int cur) {
        if (cur > n) {
            return true;
        }
        int tmp = 0;
        if (dp[cur] != -1) {
            return dp[cur] == 1;
        }
        for (int i = cur + 1; i <= cur + k; i++) {
            if (visit[i] != 1 && !recur(i)) {
                tmp += 1;
            }
        }
        if (tmp > 0) {
            dp[cur] = 1;
        } else {
            dp[cur] = 0;
        }
        return dp[cur] == 1;
    }


}
/*
10 3
1 2 4 5 7 9

정답 : 0

10 3
2 4 5 7 9

정답 : 1

10 3
2 4 5 9

정답 : 1
 */