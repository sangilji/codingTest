package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class RGBStreet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        for (int i = 1; i < n; i++) {
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
            arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]);
        }
        System.out.println(Arrays.stream(arr[n - 1]).min().getAsInt());
    }
}
