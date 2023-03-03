import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visit = new boolean[10];
    static int[] player = new int[10];
    static int[][] scores;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scores = new int[n][10];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit[1] = true;
        player[4] = 1;
        dfs(1);
        System.out.println(max);
    }

    static int max = 0;

    private static void dfs(int depth) {
        if (depth==4){
            dfs(depth+1);
            return;
        }
        if (depth == 10) {
//            System.out.println(Arrays.toString(player));
            max = Integer.max(max, start());
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            player[depth] = i;
            dfs(depth + 1);
            visit[i] = false;
        }
    }

    private static int start() {
        boolean[] map = new boolean[4];
        int sum = 0;
        int currentPlayer = 1;
        int currentInning = 0;
        int outCount = 0;
        while (currentInning < n) {
            int currentIdx = player[currentPlayer];
            int tmp = scores[currentInning][currentIdx];
            if (tmp == 0) {
                outCount++;
            } else {
                sum += go(tmp, map);
            }

            if (outCount == 3) {
                currentInning++;
                outCount = 0;
                Arrays.fill(map, false);
            }
//            System.out.println(currentIdx);
            currentPlayer++;
            if (currentPlayer == 10) {
                currentPlayer = 1;
            }
//            System.out.println(Arrays.toString(map));
//            if (player[1] == 5 && player[2] == 6 && player[3] == 7) {
//                System.out.println("sum = " + sum);
//
//            }
//            System.out.println(sum);
        }

        return sum;
    }

    private static int go(int tmp, boolean[] map) {
        int count = 0;
        if (tmp == 4) {
            count = 1;
            for (int i = 1; i < 4; i++) {
                if (map[i]) {
                    count++;
                }
            }
            Arrays.fill(map, false);
        } else if (tmp == 3) {
            for (int i = 1; i < 4; i++) {
                if (map[i]) {
                    count++;
                }
//                System.out.println(count);
            }
            Arrays.fill(map, false);
            map[3] = true;
        } else if (tmp == 2) {
            for (int i = 3; i > 0; i--) {
                if (map[i]) {
                    int idx = i + 2;
                    if (idx >= 4) {
                        count++;
                        map[i] = false;
                    } else {
                        map[idx] = true;
                        map[i] = false;
                    }
                }
            }
            map[2] = true;
        } else {
            for (int i = 3; i > 0; i--) {
                if (map[i]) {
                    int idx = i + 1;
                    if (idx >= 4) {
                        count++;
                        map[i] = false;
                    } else {
                        map[idx] = true;
                        map[i] = false;
                    }
                }
            }
            map[1] = true;
        }
        return count;
    }


}