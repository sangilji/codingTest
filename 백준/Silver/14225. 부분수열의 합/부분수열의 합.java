import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] a;
    static boolean[] visit = new boolean[2000001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);

        for (int i = 1; i < visit.length; i++) {
            if (!visit[i]){
                System.out.println(i);
                return;
            }
        }
    }

    private static void dfs(int sum, int count) {
        if (count == a.length) {
            visit[sum]= true;
            return;
        }
        dfs(sum + a[count], count + 1);
        dfs(sum, count + 1);
    }



}