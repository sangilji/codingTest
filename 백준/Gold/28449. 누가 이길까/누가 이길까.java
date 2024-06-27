import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    static int[][][][] dp;
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
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr2);
        long a = 0;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = m - 1;
            int result = -1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr2[mid] < arr[i]) {
                    start = mid + 1;
                    result = mid;
                } else {
                    end = mid - 1;
                }
            }
            a += result + 1;
        }
        sb.append(a).append(" ");
        long b=0;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = m - 1;
            int result = -1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr2[mid] <= arr[i]) {
                    start = mid + 1;
                    result = mid;
                } else {
                    end = mid -1;
                }
            }
            b += result + 1;
        }
        sb.append((long) n *m -b).append(" ");
        sb.append(b-a);
        System.out.println(sb);
    }


}