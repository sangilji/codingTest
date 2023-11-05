import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1000000000;
    static int n;
    static int r;
    static int m;
    static int k;

    static int[] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Integer>[] list;

    static int count = 0;
    static int[] arr2;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[200001];
        arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < n) {
            arr[arr2[end]]++;
            if (arr[arr2[end]] <= m) {
                sum++;
                end++;
                count = Math.max(sum, count);
            } else {
                arr[arr2[end]]--;
                arr[arr2[start]]--;
                sum--;
                start++;
            }

        }
        System.out.println(count);

    }

}