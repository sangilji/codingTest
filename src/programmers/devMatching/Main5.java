package programmers.devMatching;

import java.util.Arrays;

public class Main5 {
    String[] qrImg;
    int L;
    int H;

    public int solution(int low, int high, String[] img) {
        int answer = 0;
        qrImg = img;
        L = low;
        H = high;
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length(); j++) {
                if (img[i].charAt(j) == '#') {
                    answer += qr(i, j);
                }
            }
        }
        return answer;
    }

    private int qr(int x1, int y1) {
        int x2;
        int y2 = y1;
        int count = 0;
        for (int i = y1; i < qrImg.length; i++) {
            if (qrImg[x1].charAt(i) == '#') {
                y2++;
            } else {
                break;
            }
        }
        if (y2 - y1 < 3) {
            return 0;
        }
        for (int i = y1 + 3; i < y2; i++) {
            x2 = x1;
            for (int j = x1; j < x1 + y2 - i; i++) {
                if (qrImg[x1].charAt(i) == '#') {
                    x2++;
                } else {
                    break;
                }

            }
            System.out.println(i - y1 + ":" + (x2 - x1));
            if (y2 - i == x2 - y1) {
                if (check(x1, x2, y1, y2)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check(int x1, int x2, int y1, int y2) {
        String t = "";
        for (int i = x1 + 1; i < x2; i++) {
            for (int j = y1 + 1; j < y2; j++) {
                t += qrImg[i].charAt(j);
                System.out.print(qrImg[i].charAt(j));
            }
            System.out.println();
        }
        int blackCount = (int) Arrays.stream(t.split(""))
                .filter(b -> b.equals("#"))
                .count();
        int n = (y2 - y1) - 2;
        int rule = blackCount / (n * n) * 100;
        if (L <= rule && H > rule) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Main5 m = new Main5();
        String[] t = {"#######", "#.....#", "#.....#", "#.....#", "#..####", "#..#..#", "#######"};
        m.solution(25, 51, t);
    }
}
