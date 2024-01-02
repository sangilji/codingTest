import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;
    static int n;
    static int m;
    static List<Integer>[] list;
    static int[] parent;
    static int[] score;
    static int[] cards;
    static int[][] arr;
    static int[][][] dp;
    static int[] sz;
    static int[] visit;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        int[][] arr2 = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] tmp = st.nextToken().split("");
            for (int j = 0; j < 3; j++) {
                arr2[i][j] = Integer.parseInt(tmp[j]);
            }
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    boolean b = true;
                    for (int l = 0; l < n; l++) {
                        int strike = 0;
                        int ball = 0;
                        if (arr2[l][0] == i) {
                            strike++;
                        }
                        if (arr2[l][0] == j || arr2[l][0] == k) {
                            ball++;
                        }
                        if (arr2[l][1] == j) {
                            strike++;
                        }
                        if (arr2[l][1] == i || arr2[l][1] == k) {
                            ball++;
                        }
                        if (arr2[l][2] == k) {
                            strike++;
                        }
                        if (arr2[l][2] == j || arr2[l][2] == i) {
                            ball++;
                        }
                        if (strike != arr[l][0] || ball != arr[l][1]) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }


}