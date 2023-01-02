package baekjoon;

import java.util.Scanner;

public class Main1107 {
    private static boolean[] breakButton;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int channel = s.nextInt();
        if (channel == 100) {
            System.out.println(0);
            return;
        }
        int n = s.nextInt();
        breakButton = new boolean[10];
        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            breakButton[m] = true;
        }
        int answer = Math.abs(100 - channel);
        for (int i = 0; i < 1_000_000; i++) {
            if (check(String.valueOf(i))) {
                int tmp = Math.abs(channel - i) + String.valueOf(i).length();
                if (answer > tmp) {
                    answer = tmp;

                }

            }
        }
        if (answer == 100 - channel) {
            System.out.println(answer);
        } else {
            System.out.println(answer);
        }
    }

    private static boolean check(String i) {
        for (String s : i.split("")) {
            if (breakButton[Integer.parseInt(s)]) {
                return false;
            }
        }
        return true;
    }

}
