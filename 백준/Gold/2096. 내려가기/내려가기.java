import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = s.nextInt();
            }
        }
        int[][] minDp = new int[n][3];
        int[][] maxDp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            minDp[0][i] = map[0][i];
            maxDp[0][i] = map[0][i];
        }
        for (int i = 1; i < n; i++) {
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i < n; i++) {
            maxDp[i][1] = Math.max(maxDp[i - 1][0] + map[i][1], maxDp[i][1]);
            maxDp[i][0] = Math.max(maxDp[i - 1][0] + map[i][0], maxDp[i][0]);

            maxDp[i][2] = Math.max(maxDp[i - 1][1] + map[i][2], maxDp[i][2]);
            maxDp[i][1] = Math.max(maxDp[i - 1][1] + map[i][1], maxDp[i][1]);
            maxDp[i][0] = Math.max(maxDp[i - 1][1] + map[i][0], maxDp[i][0]);

            maxDp[i][2] = Math.max(maxDp[i - 1][2] + map[i][2], maxDp[i][2]);
            maxDp[i][1] = Math.max(maxDp[i - 1][2] + map[i][1], maxDp[i][1]);

            minDp[i][1] = Math.min(minDp[i - 1][0] + map[i][1], minDp[i][1]);
            minDp[i][0] = Math.min(minDp[i - 1][0] + map[i][0], minDp[i][0]);

            minDp[i][2] = Math.min(minDp[i - 1][1] + map[i][2], minDp[i][2]);
            minDp[i][1] = Math.min(minDp[i - 1][1] + map[i][1], minDp[i][1]);
            minDp[i][0] = Math.min(minDp[i - 1][1] + map[i][0], minDp[i][0]);

            minDp[i][2] = Math.min(minDp[i - 1][2] + map[i][2], minDp[i][2]);
            minDp[i][1] = Math.min(minDp[i - 1][2] + map[i][1], minDp[i][1]);


        }
        System.out.println(Arrays.stream(maxDp[n - 1])
                .max()
                .getAsInt() + " " + Arrays.stream(minDp[n - 1])
                .min()
                .getAsInt());
    }
}
