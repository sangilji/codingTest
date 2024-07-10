import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[][] arr;
    static int[] tree;
    static int[] treeMaxIndex;
    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};
    static long[] dp;
    static List<int[]>[] list;
    static List<int[]>[] list2;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        arr = new int[][]{{0},{12,1600},{11,894},{11,1327},{10,1311},{9,1004},{9,1178},{9,1357},{8,837},{7,1055},{6,556},{6,773}};

        sb.append(arr[n][0]).append(" ").append(arr[n][1]);
        System.out.println(sb);
    }
}