import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] tree;
    static double sum;
    static int[] visit;
    static int[] visit2;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {1, -1, 1, -1};
    static int[] dy = {1, 1, -1, -1};
    static int[] arr1;
    static int count = 0;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static Set<Integer> set = new HashSet<>();
    static int l;
    static int r;
    static int x;
    static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[12];
        visit = new int[12];
        visit2 = new int[12];
        result = new char[5][9];

        int index = 0;
        for (int i = 0; i < 5; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                result[i][j] = tmp[j].charAt(0);
                if (tmp[j].equals("x")) {
                    index++;
                } else if (!tmp[j].equals(".")) {
                    visit[tmp[j].charAt(0) - 'A'] = 1;
                    visit2[index] = 1;
                    arr[index++] = tmp[j].charAt(0) - 'A' + 1;
                }
            }
        }
        recur(0);

    }

    static boolean finish = false;

    private static void recur(int depth) {
        if (finish) {
            return;
        }
        if (depth == 12) {
            if (check()) {
                finish = true;
                int index = 0;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (result[i][j] == '.') {
                            sb.append(".");
                        } else if (result[i][j] == 'x') {
                            sb.append((char) ('A' + arr[index++] - 1));
                        } else {
                            index++;
                            sb.append(result[i][j]);
                        }
                    }
                    sb.append("\n");
                }
                System.out.println(sb);
            }
            return;
        }

        if (visit2[depth] == 1) {
            recur(depth + 1);
            return;
        }
        for (int i = 0; i < 12; i++) {
            if (visit[i] == 1) {
                continue;
            }
            arr[depth] = i + 1;
            visit[i] = 1;
            recur(depth + 1);
            visit[i] = 0;
        }

    }

    private static boolean check() {

        if (arr[0] + arr[2] + arr[5] + arr[7] != 26) {
            return false;
        }
        if (arr[1] + arr[2] + arr[3] + arr[4] != 26) {
            return false;
        }
        if (arr[7] + arr[8] + arr[9] + arr[10] != 26) {
            return false;
        }
        if (arr[1] + arr[5] + arr[8] + arr[11] != 26) {
            return false;
        }
        if (arr[0] + arr[3] + arr[6] + arr[10] != 26) {
            return false;
        }
        if (arr[4] + arr[6] + arr[9] + arr[11] != 26) {
            return false;
        }
        return true;
    }


}