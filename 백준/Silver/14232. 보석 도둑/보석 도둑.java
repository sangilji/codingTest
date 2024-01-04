import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;
    static long n;
    static long m;
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
        n = Long.parseLong(br.readLine());
        long tmp = n;
        List<Long> list = new ArrayList<>();
        for (long i = 2; i * i <= n; i++) {
            while (tmp % i == 0) {
                list.add(i);
                tmp /= i;
            }
        }
        if (tmp != 1) {
            list.add(tmp);
        }
        sb.append(list.size()).append("\n");
        for (Long i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

}