package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Main1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] scores = new int[101];
            for (int i = 0; i < 1000; i++) {
                int score = sc.nextInt();
                scores[score]++;
            }
            int maxValue = Arrays.stream(scores).max().getAsInt();
            int maxScore = 100;
            for (int i = 100; i >= 0; i--) {
                if (scores[i] == maxValue) {
                    maxScore = i;
                    break;
                }
            }
            System.out.printf("#%d %d\n", test_case, maxScore);
        }
    }
}
