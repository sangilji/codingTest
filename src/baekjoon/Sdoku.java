package baekjoon;

import java.util.Scanner;

public class Sdoku {
    static int[][] sdoku;

    public static void main(String[] args) {
        sdoku = new int[9][9];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = s.nextInt();
            }
        }
        f(0, 0);

    }

    private static void f(int a, int b) {
        if (b == 9) {
            f(a + 1, 0);
            return;
        }
        if (a == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sdoku[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);

        }
        if (sdoku[a][b] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(a, b, i)) {
                    sdoku[a][b] = i;
                    f(a, b + 1);
                }
            }
            sdoku[a][b] = 0;
            return;
        }

        f(a, b + 1);
    }

    private static boolean possibility(int a, int b, int value) {
        for (int i = 0; i < 9; i++) {
            if (sdoku[a][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sdoku[i][b] == value) {
                return false;
            }
        }


        int set_row = (a / 3) * 3;
        int set_col = (b / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (sdoku[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

}
