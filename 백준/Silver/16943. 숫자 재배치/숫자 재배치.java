import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int n;
    static int m;
    static int k;
    static int[] arr;
    static int[] arr2;
    static int[] a;
    static int[] b;
    static int[] visit;
    static int[] dp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
        arr2 = new int[arr.length];
        visit = new int[arr.length];
        dfs(0);

        int max = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < m) {
                max = Math.max(max, list.get(i));
            }
        }
        System.out.println(max);
    }

    private static void dfs(int depth) {
        if (depth == arr.length) {
            if (arr2[0] == 0) {
                return;
            }
            int count = 0;
            for (int i = 0; i < arr2.length; i++) {
                count = count * 10 + arr2[i];
            }
            list.add(count);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            arr2[depth] = arr[i];
            dfs(depth + 1);
            visit[i] = 0;
        }
    }


}