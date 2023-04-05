import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static int n;

    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, map);

        System.out.println(max);
    }

    private static void dfs(int depth, int[][] map) {
        if (depth == 10) {
            findMax(map);

            return;
        }
        int[][] tmpMap = new int[n][n];
        for (int j = 1; j <= 4; j++) {
            for (int i = 0; i < n; i++) {
                tmpMap[i] = map[i].clone();
            }
            move(j, tmpMap);
            dfs(depth+1,tmpMap);
        }
    }
    private static void move(int d, int[][] map) { // 1 위 2  왼쪽 3 아래 4 오른쪽
        if (d == 1) {
            for (int i = 0; i < n; i++) {
                int blankIndex = 0;
                int tmpNumber = -1;
                for (int j = 0; j < n; j++) {
                    if (map[j][i] == 0) {
                        continue;
                    }
                    if (map[j][i] == tmpNumber) {
                        map[blankIndex][i] = map[j][i] * 2;
                        tmpNumber = -1;
                        blankIndex++;
                    } else {
                        if (tmpNumber!=-1){
                            map[blankIndex][i] = tmpNumber;
                            blankIndex++;
                        }
                        tmpNumber = map[j][i];
                    }
                }
                if (tmpNumber!=-1){
                    map[blankIndex][i] = tmpNumber;
                    blankIndex++;
                }
                for (int j = blankIndex; j < n; j++) {
                    map[j][i] = 0;
                }
            }
        }
        if (d==2){
            for (int i = 0; i < n; i++) {
                int blankIndex = 0;
                int tmpNumber = -1;
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0) {
                        continue;
                    }
                    if (map[i][j] == tmpNumber) {
                        map[i][blankIndex] = map[i][j] * 2;
                        tmpNumber = -1;
                        blankIndex++;
                    } else {
                        if (tmpNumber!= -1) {
                            map[i][blankIndex] = tmpNumber;
                            blankIndex++;
                        }
                        tmpNumber = map[i][j];
                    }
                }
                if (tmpNumber!=-1){
                    map[i][blankIndex] = tmpNumber;
                    blankIndex++;
                }
                for (int j = blankIndex; j < n; j++) {
                    map[i][j] = 0;
                }
            }
        }
        if (d == 3) {
            for (int i = 0; i < n; i++) {
                int blankIndex = n-1;
                int tmpNumber = -1;
                for (int j = n-1; j >= 0; j--) {
                    if (map[j][i] == 0) {
                        continue;
                    }
                    if (map[j][i] == tmpNumber) {
                        map[blankIndex][i] = map[j][i] * 2;
                        tmpNumber = -1;
                        blankIndex--;
                    } else {
                        if (tmpNumber!=-1){
                            map[blankIndex][i] = tmpNumber;
                            blankIndex--;
                        }
                        tmpNumber = map[j][i];
                    }
                }
                if (tmpNumber!=-1){
                    map[blankIndex][i] = tmpNumber;
                    blankIndex--;
                }
                for (int j = blankIndex; j >= 0; j--) {
                    map[j][i] = 0;
                }
            }
        }
        if (d == 4) {
            for (int i = 0; i < n; i++) {
                int blankIndex = n-1;
                int tmpNumber = -1;
                for (int j = n-1; j >= 0; j--) {
                    if (map[i][j] == 0) {
                        continue;
                    }
                    if (map[i][j] == tmpNumber) {
                        map[i][blankIndex] = map[i][j] * 2;
                        tmpNumber = -1;
                        blankIndex--;
                    } else {
                        if (tmpNumber!=-1){
                            map[i][blankIndex] = tmpNumber;
                            blankIndex--;
                        }
                        tmpNumber = map[i][j];
                    }
                }
                if (tmpNumber!=-1){
                    map[i][blankIndex] = tmpNumber;
                    blankIndex--;
                }
                for (int j = blankIndex; j >= 0; j--) {
                    map[i][j] = 0;
                }
            }
        }
    }

    static int max = 0;

    private static void findMax(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, map[i][j]);
            }
        }
    }


}