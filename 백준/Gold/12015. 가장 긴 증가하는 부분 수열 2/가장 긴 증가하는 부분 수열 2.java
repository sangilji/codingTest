import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static long[] tree;
    static int[] dp;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int size = 0;
        for (int i = 1; i < arr.length; i++) {
            int tmp = search(size, arr[i]);
            dp[tmp] = arr[i];
            size = Math.max(size, tmp + 1);
        }
        System.out.println(size);
    }

    private static int search(int size, int target) {
        int left = 0;
        int right = size;
        int result = right;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}