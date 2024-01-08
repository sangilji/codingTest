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
        n = Integer.parseInt(br.readLine());
        System.out.println((int) Math.sqrt(n));
    }


}