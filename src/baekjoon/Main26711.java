package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main26711 {
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int maxLen = Math.max(a.length(), b.length());
        int[] A = new int[maxLen + 1];
        int[] B = new int[maxLen + 1];

        for (int i = a.length() - 1, idx = 0; i >= 0; i--, idx++) {
            A[idx] = a.charAt(i) - '0';
        }
        for (int i = b.length() - 1, idx = 0; i >= 0; i--, idx++) {
            B[idx] = b.charAt(i) - '0';
        }
        for (int i = 0; i < maxLen; i++) {
            int value = A[i] + B[i];
            A[i] = value % 10;
            A[i + 1] = A[i + 1] + (value / 10);
        }
        StringBuilder sb = new StringBuilder();
        if (A[maxLen] != 0) {
            sb.append(A[maxLen]);
        }
        for (int i = maxLen - 1; i >= 0; i--) {
            sb.append(A[i]);
        }
        System.out.println(sb);
    }
}
