import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Set;

public class Main {
    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int[] arr2;
    static int[] costs;
    static int[] visit;
    static int[] visit2;
    static long[] sz;
    static int[] depth;
    static int[] parent;
    static int[] top;
    static int[] in;
    static int[] out;
    static int[] tree;
    static long[] tree_max;
    static List<Integer>[] list;
    static List<Integer>[] graph;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static long count = 0;
    static int[][] dp;
    static int[][] dp2;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] s = new String[3];
        for (int i = 0; i < 3; i++) {
            s[i] = br.readLine();
        }
        int n = 0;
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if (s[i].equals("FizzBuzz") || s[i].equals("Fizz") || s[i].equals("Buzz")) {
                continue;
            }
            n = Integer.parseInt(s[i]);
            index = i + 1;
        }
        // 1 2 3
        n += 4-index;
        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (n % 3 == 0) {
            System.out.println("Fizz");
        } else if (n % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(n);
        }


    }

}