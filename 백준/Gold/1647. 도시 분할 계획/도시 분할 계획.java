import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = i;
        }
        int[][] cost = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(cost, Comparator.comparingInt(o -> o[2]));

        int sum = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            int ta = check(cost[i][0]);
            int tb = check(cost[i][1]);
            if (ta != tb){

                if (ta<tb){
                    arr[tb] = ta;
                } else {
                    arr[ta] = tb;
                }
                sum+= cost[i][2];
                max = Math.max(max,cost[i][2]);
            }
        }
        System.out.println(sum-max);
    }

    private static int check(int i) {
        if (i == arr[i]) {
            return i;
        }
        return arr[i] = check(arr[i]);
    }
}
