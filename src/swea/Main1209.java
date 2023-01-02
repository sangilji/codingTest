package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        for (int test_case = 1; test_case <= 10; test_case++) {
            T = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int maxValue = 0;
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int columnSum = 0;
                for (int j = 0; j < 100; j++) {
                    columnSum += map[i][j];
                    rowSum += map[j][i];
                }
                maxValue = Math.max(maxValue, Math.max(columnSum, rowSum));
            }
            int cross = 0;
            for (int i = 0, j = 0; i < 100; i++, j++) {
                cross += map[i][j];
            }
            maxValue = Math.max(cross, maxValue);
            cross = 0;
            for (int i = 0, j = 99; i < 100; i++, j--) {
                cross += map[i][j];
            }
            maxValue = Math.max(cross, maxValue);
            System.out.printf("#%d %d\n", test_case, maxValue);
        }
    }
}
