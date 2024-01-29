import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] arr;

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long start = 0;
        long end = Integer.MAX_VALUE;
        boolean b = false;
        while (start <= end) {
            long mid = (start + end) >> 1;
            if (check(mid)%2==0) {
                start = mid + 1;
            } else {
                end = mid - 1;
                b = true;
            }
        }
        if (!b) {
            System.out.println("NOTHING");
            return;
        }
        long sum1 = check(start);
        long sum2 = check(start-1);
        System.out.println(start +" " +(sum1-sum2));
    }

    private static long check(long mid) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (mid >= arr[i][0]) { //  a +kb <=c
                long k = Math.min(arr[i][1], mid) - arr[i][0];
                count += 1 + (k / arr[i][2]);
            }
        }
        return count;
    }
}