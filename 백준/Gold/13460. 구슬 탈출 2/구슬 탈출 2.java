import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static String[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }
        bfs();

    }

    private static void bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[4]));

        int redBallX = 0;
        int redBallY = 0;
        int blueBallX = 0;
        int blueBallY = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].equals("R")) {
                    redBallX = i;
                    redBallY = j;
                    map[i][j] = "";
                }
                if (map[i][j].equals("B")) {
                    blueBallX = i;
                    blueBallY = j;
                    map[i][j] = "";
                }
            }
        }
        q.add(new int[]{redBallX, redBallY, blueBallX, blueBallY, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[4]>=10){
                break;
            }
            for (int i = 0; i < 4; i++) {
                int[] pos = move(i, tmp);
                if (pos.length == 0) {
                } else if (pos.length == 100) {
                    System.out.println(tmp[4] + 1);
                    return;
                } else {
//                    System.out.println(pos[0]+":"+pos[1]);
//                    System.out.println(pos[2]+":"+pos[3]);
                    q.add(new int[]{pos[0], pos[1], pos[2], pos[3], tmp[4] + 1});
                }
            }
        }
        System.out.println(-1);
    }

    private static int[] move(int d, int[] tmp) {
        int rX = tmp[0];
        int rY = tmp[1];
        int bX = tmp[2];
        int bY = tmp[3];
        if (d == 0) {
            if (rY < bY) {
                while (true) {
                    bX += dx[d];
                    bY += dy[d];
                    if (bX < 0 || bY < 0 || bX >= n || bY >= m || map[bX][bY].equals("#")) {
                        bX -= dx[d];
                        bY -= dy[d];
                        break;
                    }
                    if (map[bX][bY].equals("O")) {
                        return new int[0];
                    }
                }
                while (true) {
                    rX += dx[d];
                    rY += dy[d];
                    if (rX < 0 || rY < 0 || rX >= n || rY >= m || map[rX][rY].equals("#") || (rX == bX && rY == bY)) {
                        rX -= dx[d];
                        rY -= dy[d];
                        break;
                    }
                    if (map[rX][rY].equals("O")) {
                        return new int[100];
                    }
                }
            } else {
                boolean b = false;
                while (true) {
                    rX += dx[d];
                    rY += dy[d];
                    if (rX < 0 || rY < 0 || rX >= n || rY >= m || map[rX][rY].equals("#")) {
                        rX -= dx[d];
                        rY -= dy[d];
                        break;
                    }
                    if (map[rX][rY].equals("O")) {
                        b= true;
                        rX=-1;
                        rY =-1;
                    }
                }
                while (true) {
                    bX += dx[d];
                    bY += dy[d];
                    if (bX < 0 || bY < 0 || bX >= n || bY >= m || map[bX][bY].equals("#") || (rX == bX && rY == bY)) {
                        bX -= dx[d];
                        bY -= dy[d];
                        break;
                    }
                    if (map[bX][bY].equals("O")) {
                        return new int[0];
                    }
                }
                if (b){
                    return new int[100];
                }
            }
        }
        if (d == 1) {
            if (rX < bX) {
                while (true) {
                    bX += dx[d];
                    bY += dy[d];
                    if (bX < 0 || bY < 0 || bX >= n || bY >= m || map[bX][bY].equals("#")) {
                        bX -= dx[d];
                        bY -= dy[d];
                        break;
                    }
                    if (map[bX][bY].equals("O")) {
                        return new int[0];
                    }
                }
                while (true) {
                    rX += dx[d];
                    rY += dy[d];
                    if (rX < 0 || rY < 0 || rX >= n || rY >= m || map[rX][rY].equals("#") || (rX == bX && rY == bY)) {
                        rX -= dx[d];
                        rY -= dy[d];
                        break;
                    }
                    if (map[rX][rY].equals("O")) {
                        return new int[100];
                    }
                }
            } else {
                boolean b = false;
                while (true) {
                    rX += dx[d];
                    rY += dy[d];
                    if (rX < 0 || rY < 0 || rX >= n || rY >= m || map[rX][rY].equals("#")) {
                        rX -= dx[d];
                        rY -= dy[d];
                        break;
                    }
                    if (map[rX][rY].equals("O")) {
                        b= true;
                        rX=-1;
                        rY =-1;
                    }
                }
                while (true) {
                    bX += dx[d];
                    bY += dy[d];
                    if (bX < 0 || bY < 0 || bX >= n || bY >= m || map[bX][bY].equals("#") || (rX == bX && rY == bY)) {
                        bX -= dx[d];
                        bY -= dy[d];
                        break;
                    }
                    if (map[bX][bY].equals("O")) {
                        return new int[0];
                    }
                }
                if (b){
                    return new int[100];
                }
            }
        }
        if (d == 2) {
            if (rY < bY) {
                boolean b = false;
                while (true) {
                    rX += dx[d];
                    rY += dy[d];
                    if (rX < 0 || rY < 0 || rX >= n || rY >= m || map[rX][rY].equals("#")) {
                        rX -= dx[d];
                        rY -= dy[d];
                        break;
                    }
                    if (map[rX][rY].equals("O")) {
                        b= true;
                        rX=-1;
                        rY =-1;
                    }
                }
                while (true) {
                    bX += dx[d];
                    bY += dy[d];
                    if (bX < 0 || bY < 0 || bX >= n || bY >= m || map[bX][bY].equals("#") || (rX == bX && rY == bY)) {
                        bX -= dx[d];
                        bY -= dy[d];
                        break;
                    }
                    if (map[bX][bY].equals("O")) {
                        return new int[0];
                    }
                }
                if (b){
                    return new int[100];
                }
            } else {
                while (true) {
                    bX += dx[d];
                    bY += dy[d];
                    if (bX < 0 || bY < 0 || bX >= n || bY >= m || map[bX][bY].equals("#")) {
                        bX -= dx[d];
                        bY -= dy[d];
                        break;
                    }
                    if (map[bX][bY].equals("O")) {
                        return new int[0];
                    }
                }
                while (true) {
                    rX += dx[d];
                    rY += dy[d];
                    if (rX < 0 || rY < 0 || rX >= n || rY >= m || map[rX][rY].equals("#") || (rX == bX && rY == bY)) {
                        rX -= dx[d];
                        rY -= dy[d];
                        break;
                    }
                    if (map[rX][rY].equals("O")) {
                        return new int[100];
                    }
                }
            }
        }
        if (d == 3) {
            if (rX < bX) {
                boolean b = false;
                while (true) {
                    rX += dx[d];
                    rY += dy[d];
                    if (rX < 0 || rY < 0 || rX >= n || rY >= m || map[rX][rY].equals("#")) {
                        rX -= dx[d];
                        rY -= dy[d];
                        break;
                    }
                    if (map[rX][rY].equals("O")) {
                        b= true;
                        rX=-1;
                        rY =-1;
                    }
                }
                while (true) {
                    bX += dx[d];
                    bY += dy[d];
                    if (bX < 0 || bY < 0 || bX >= n || bY >= m || map[bX][bY].equals("#") || (rX == bX && rY == bY)) {
                        bX -= dx[d];
                        bY -= dy[d];
                        break;
                    }
                    if (map[bX][bY].equals("O")) {
                        return new int[0];
                    }
                }
                if (b){
                    return new int[100];
                }
            } else {
                while (true) {
                    bX += dx[d];
                    bY += dy[d];
                    if (bX < 0 || bY < 0 || bX >= n || bY >= m || map[bX][bY].equals("#")) {
                        bX -= dx[d];
                        bY -= dy[d];
                        break;
                    }
                    if (map[bX][bY].equals("O")) {
                        return new int[0];
                    }
                }
                while (true) {
                    rX += dx[d];
                    rY += dy[d];
                    if (rX < 0 || rY < 0 || rX >= n || rY >= m || map[rX][rY].equals("#") || (rX == bX && rY == bY)) {
                        rX -= dx[d];
                        rY -= dy[d];
                        break;
                    }
                    if (map[rX][rY].equals("O")) {
                        return new int[100];
                    }
                }
            }
        }
        return new int[]{rX, rY, bX, bY};
    }
}