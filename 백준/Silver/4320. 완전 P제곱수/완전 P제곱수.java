import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;
    static int n;
    static int m;
    static List<int[]>[] list;
    static int[] parent;
    static int[] score;
    static int[] cards;
    static int[] depth;
    static int[] sz;
    static int[] visit;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            long n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            long result = 1;
            if (n > 0) {
                top:
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    for (int j = 0; j <= 31; j++) {
                        long tmp = (long) Math.pow(i, j);
                        if (tmp > n) {
                            break;
                        }
                        if (tmp == n) {
                            result = j;
                            break top;
                        }
                    }
                }
            } else {
                top:
                for (int i = -2; i >= -Math.sqrt(Math.abs(n)); i--) {
                    for (int j = 3; j <= 31; j += 2) {
                        long tmp = (long) Math.pow(i, j);
                        if (tmp < n) {
                            break;
                        }
                        if (tmp == n) {
                            result = j;
                            break top;
                        }
                    }
                }
            }
            sb.append(result).append("\n");


        }
        System.out.println(sb);


    }

}