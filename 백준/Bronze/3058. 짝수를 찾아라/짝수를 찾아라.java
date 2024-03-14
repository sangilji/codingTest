import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] arr2;
    static int[][] arr1;

    static long[] tree;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = 7;
            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            int min = 1000000000;
            for (int j = 0; j < n; j++) {
                if (arr[j] % 2 == 0) {
                    sum += arr[j];
                    min = Math.min(min, arr[j]);
                }
            }
            sb.append(sum).append(" ").append(min).append("\n");
        }
        System.out.println(sb);

    }



}