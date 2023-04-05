import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) {
                map[j][k] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        int[] checkMap = new int[n];
        for (int j = 0; j < n; j++) {
            result += check(map[j]);
            for (int k = 0; k < n; k++) {
                checkMap[k] = map[k][j];
            }
            result += check(checkMap);
        }
        System.out.println(result);

    }

    private static int check(int[] map) {
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            if (map[i] != map[i + 1]) {
                if (Math.abs(map[i] - map[i + 1]) > 1) {
                    return 0;
                }

                if (map[i] < map[i + 1]) {
                    if (i - x < -1) {
                        return 0;
                    }
                    for (int j = i; j > i - x; j--) {
                        if (visit[j]) {
                            return 0;
                        }
                        if (map[j] == map[i]) {
                            count++;
                            visit[j] = true;
                        }
                    }
                } else {
                    if (i + x >= n) {
                        return 0;
                    }
                    for (int j = i + 1; j <= i + x; j++) {
                        if (map[j] == map[i + 1]) {
                            count++;
                            visit[j] = true;
                        }
                    }
                }
                ;
                if (count != x) {
                    return 0;
                }
            }
        }
        return 1;
    }
}