import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][2];
        dp = new int[n + 1];
        int[] index = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int size = 0;
        for (int i = 1; i < arr.length; i++) {
            int tmp = search(size, arr[i][1]);
            dp[tmp] = arr[i][1];
            size = Math.max(size, tmp + 1);
            index[i] = tmp + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n - size).append("\n");
        int s = size;
        int c = n - size;
        for (int i = n; i > 0; i--) {
            if (index[i] == s) {
                s--;
            } else {
                c--;
                dp[c] = arr[i][0];

            }
        }

        for (int i = 0; i < n - size; i++) {
            sb.append(dp[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static int search(int size, int target) {
        int left = 0;
        int right = size;
        while (left < right) {
            int mid = (left + right) / 2;

            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}