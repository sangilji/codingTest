package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    static int countZero = 0;
    static int countOne = 0;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            fibonacci(Integer.parseInt(br.readLine()));
            sb.append(countZero).append(" ").append(countOne).append("\n");
            countOne = countZero = 0;
        }
        System.out.println(sb);
    }

    private static void fibonacci(int n) {
        int tmp = 0;
        int tmp1 = 0;
        int tmp2 = 1;
        if (n == 0) {
            countZero++;
        } else if (n == 1) {
            countOne++;
        } else {
            for (int i = 1; i < n; i++) {
                tmp = tmp1 + tmp2;
                tmp1 = tmp2;
                tmp2 = tmp;
            }
            countZero = tmp1;
            countOne = tmp2;
        }

    }

}
