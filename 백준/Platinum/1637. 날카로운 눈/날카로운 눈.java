import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean b = false;
        long start = 1;
        long last = Integer.MAX_VALUE;
        long mid = 0;
        while (start <= last) {
            mid = (start + last) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (mid >= arr[i][0]) {
                    long end = Math.min(arr[i][1], mid) - arr[i][0];
                    sum += 1 + (end / arr[i][2]);
                }
            }
            if (sum % 2 == 0) {
                start = mid + 1;
            } else {
                last = mid - 1;
                b = true;
            }
        }
        if (!b) {
            System.out.println("NOTHING");
        } else {
            long sum1 = 0;
            for (int i = 0; i < n; i++) {
                if (start >= arr[i][0]) {
                    long end = Math.min(arr[i][1], start) - arr[i][0];
                    sum1 += 1 + (end / arr[i][2]);
                }
            }

            long sum2 = 0;
            for (int i = 0; i < n; i++) {
                if (start >= arr[i][0]) {
                    long end = Math.min(arr[i][1], start - 1) - arr[i][0];
                    sum2 += 1 + (end / arr[i][2]);
                }
            }

            System.out.println(start + " " + (sum1 - sum2));

        }

    }


}