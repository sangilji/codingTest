package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main1654 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int n = s.nextInt();
        long[] line = new long[k];

        for (int i = 0; i < k; i++) {
            line[i] = s.nextInt();
        }
        long left = 0;
        long right = Arrays.stream(line).max().getAsLong() + 1;
        long mid;

        while (left < right) {
            long count = 0;
            mid = (left + right) / 2;
            for (int i = 0; i < k; i++) {
                count += (line[i] / mid);
            }
            if (count < n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
}
