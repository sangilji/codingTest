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
        int[] prime = new int[1001];
        prime[0] = 1;
        prime[1] = 1;
        for (int i = 2; i <= 1000; i++) {
            if (prime[i] == 1) {
                continue;
            }
            for (int j = i * i; j <= 1000; j += i) {
                prime[j] = 1;
            }
        }
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (prime[tmp] == 0) {
                count++;
            }
        }
        System.out.println(count);

    }

}