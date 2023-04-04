import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int[][] x;
    public static int n, m;
    public static int INF = 99999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int t = Integer.parseInt(br.readLine());

        //for (int i = 1; i <= t; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //n = Integer.parseInt(br.readLine());
        //m = Integer.parseInt(br.readLine());

        x = new int[n][n];

        for (int j = 0; j < m; j++) {
            //StringTokenizer st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            x[a][b] = 1;
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (x[j][k] == 0) {
                    x[j][k] = INF;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (j == k) {
                    continue;
                }
                for (int l = 0; l < n; l++) {
                    if (l == k || j == l) {
                        continue;
                    }
                    if (x[k][l] > x[k][j] + x[j][l]) {
                        x[k][l] = x[k][j] + x[j][l];
                    }

                }

            }
        }
        int[] res = new int[n];

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (j != k) {
                    if (x[j][k] + x[k][j] < 199998) {
                        res[j] += 1;
                    }
                }
            }
        }
        int cnt = 0;
        for (int j = 0; j < res.length; j++) {
            //System.out.print(res[j]+" ");
            if (res[j] == n - 1) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
        //System.out.print("#" + i + " " + cnt);
        //System.out.println();
            /*
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(x[j][k]+"\t\t\t");
                }
                System.out.println();
            }*/
    }
    //}

}