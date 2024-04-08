import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static double sum;
    static int[] visit;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr1;
    static int count = 0;
    static long[][][] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static int[] result;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) {
                arr[i][0] = b;
                arr[i][1] = a;
            } else {
                arr[i][0] = a;
                arr[i][1] = b;

            }
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        int result = 0;
        m = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peek() < arr[i][1] - m) {
                q.poll();
                count--;
            }
            if (arr[i][0] >= arr[i][1] - m) {
                count++;
                q.add(arr[i][0]);
            }
            result = Math.max(result, count);
        }
        System.out.println(result);

    }


}