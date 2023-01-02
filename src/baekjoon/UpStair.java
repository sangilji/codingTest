package baekjoon;

import java.util.Scanner;

public class UpStair {
    static int sum = 0;
    static int[] stair;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        stair = new int[300];
        int[] score = new int[300];
        for (int i = 0; i < a; i++) {
            stair[i] = s.nextInt();
        }
        score[0] = stair[0];
        score[1] = stair[0] + stair[1];
        score[2] = Math.max(stair[0], stair[1]) + stair[2];
        for (int i = 3; i < a; i++) {
            score[i] = Math.max(score[i - 2], stair[i - 1] + score[i - 3]) + stair[i];
        }
        System.out.println(score[a - 1]);
    }
}
