package baekjoon;

import java.util.Scanner;

public class ContinueSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int sum = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            max = Math.max(max, sum);
        }
        System.out.println(max + "");
    }
}
