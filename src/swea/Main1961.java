package swea;

import java.util.Scanner;

public class Main1961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            print(map,test_case);


        }
    }

    private static void print(int[][] map, int test_case) {
        StringBuilder sb = new StringBuilder("#").append(test_case).append("\n");
        for (int pos = 0; pos < map.length; pos++) {
            for (int i = map.length - 1; i >= 0; i--) {
                sb.append(map[i][pos]);
            }
            sb.append(" ");
            for (int i = map.length - 1; i >= 0; i--) {
                sb.append(map[map.length - pos - 1][i]);
            }
            sb.append(" ");
            for (int i = 0; i < map.length; i++) {
                sb.append(map[i][map.length-pos-1]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
