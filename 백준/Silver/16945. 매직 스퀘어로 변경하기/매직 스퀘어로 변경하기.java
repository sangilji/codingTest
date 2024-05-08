import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        arr = new int[10];
        visit = new int[10];
        visit2 = new int[10];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i * 3 + j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(recur(1));

    }

    private static int recur(int depth) {
        if (depth == 10) {
            if (check()) {
                int sum = 0;
                for (int i = 1; i < 10; i++) {
                    sum += Math.abs(arr[i] - visit2[i]);
                }
                return sum;
            }
            return INF;
        }

        int tmp = INF;
        for (int i = 1; i <= 9; i++) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            visit2[depth] = i;
            tmp = Math.min(tmp, recur(depth + 1));
            visit[i] = 0;
        }
        return tmp;
    }

    private static boolean check() {
        int tmp = visit2[1] + visit2[2] + visit2[3];
        if (tmp != visit2[4] + visit2[5] + visit2[6]) {
            return false;
        }
        if (tmp != visit2[7] + visit2[8] + visit2[9]) {
            return false;
        }
        if (tmp != visit2[1] + visit2[4] + visit2[7]) {
            return false;
        }
        if (tmp != visit2[2] + visit2[5] + visit2[8]) {
            return false;
        }
        if (tmp != visit2[3] + visit2[6] + visit2[9]) {
            return false;
        }
        if (tmp != visit2[1] + visit2[5] + visit2[9]) {
            return false;
        }
        if (tmp != visit2[3] + visit2[5] + visit2[7]) {
            return false;
        }
        return true;
    }


}