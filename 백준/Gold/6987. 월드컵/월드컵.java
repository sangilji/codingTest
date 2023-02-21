import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] team = new int[6][3];
    static int[][] result = new int[4][18];
    static boolean[] visit = new boolean[4];

    static int[] t1 = {0, 1, 2};
    static int[] t2 = {2, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 18; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        make(0, 0, 1);

        for (int i = 0; i < 4; i++) {
            if (visit[i]) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }

    private static void make(int depth, int a, int b) {
        if (depth == 15) {
            check();
            return;
        }

        for (int i = 0; i < 3; i++) {
            team[a][t1[i]]++;
            team[b][t2[i]]++;

            if (b + 1 == 6) {
                make(depth + 1, a + 1, a + 2);
            } else {
                make(depth + 1, a, b + 1);
            }

            team[a][t1[i]]--;
            team[b][t2[i]]--;

        }
    }

    private static void check() {
        boolean b;
        for (int i = 0; i < 4; i++) {
            b=true;
            if (visit[i]) {
                continue;
            }

            for (int j = 0; j < 18; j++) {
                if (result[i][j] != team[j / 3][j % 3]) {
                    b = false;
                    break;
                }
            }
            if (b) {
                visit[i] = true;
            }
        }
    }
}