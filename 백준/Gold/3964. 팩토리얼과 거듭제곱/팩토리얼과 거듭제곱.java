import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            Map<Long, Integer> map = new HashMap<>();
            long tmp = k;
            for (long j = 2; j <= Math.sqrt(k); j++) {
                while (tmp % j == 0) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                    tmp /= j;
                }
            }
            if (tmp != 1) {
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
            long max = Long.MAX_VALUE;
            for (long key : map.keySet()) {
                long count = 0;
                int value = map.get(key);
                tmp = n;
                while (tmp != 0) {
                    count += tmp / key;
                    tmp /= key;
                }
                max = Math.min(count / value, max);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }

}