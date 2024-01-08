import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;
    static long n;
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
        String tmp = br.readLine();
        n = Long.parseLong(tmp);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println("no");
                return;
            }
        }
        for (int i = tmp.length() - 1; i >= 0; i--) {
            if (tmp.charAt(i) == '6') {
                sb.append(9);
            } else if (tmp.charAt(i) == '9') {
                sb.append(6);
            } else if (tmp.charAt(i) == '3' || tmp.charAt(i) == '4' || tmp.charAt(i) == '7') {
                System.out.println("no");
                return;
            } else {
                sb.append(tmp.charAt(i));
            }
        }
        long num = Long.parseLong(sb.toString());
        if (num == 1) {
            System.out.println("no");
            return;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }


}