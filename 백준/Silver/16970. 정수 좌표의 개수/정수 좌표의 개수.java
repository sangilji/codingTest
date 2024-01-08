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
    static int[] arr;
    static int[][][] dp;
    static int[] sz;
    static int[] visit;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        int count2 = 0;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int l = 0; l <= x; l++) {
                    for (int o = 0; o <= y; o++) {
                        if (i >= l && j >= o) {
                            continue;
                        }
                        int n = Math.abs(l - i);
                        int m = Math.abs(j - o);
                        int tmp = gcd(n, m);
                        if (k == tmp + 1) {
                            count++;
                            if (i > l && j < o || i < l && j > o) {
                                count2++;
                            }
                        }

                    }
                }
            }
        }
        System.out.println(count - count2 / 2);
    }

    private static int gcd(int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a == 0) {
            return b;
        }
        while (b % a != 0) {
            b %= a;
            int tmp = a;
            a = b;
            b = tmp;
        }
        return a;
    }


}