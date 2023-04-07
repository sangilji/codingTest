import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        tree = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            add(i, arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(sum(b) - sum(a - 1)).append("\n");
        }
        System.out.println(sb);
    }

    public static void add(int i, int num) {
        while (i <= n) {
            tree[i] += num;
            i += (i & -i);
        }
    }

    public static int sum(int i) {
        int tmp = 0;
        while (i > 0) {
            tmp += tree[i];
            i -= (i & -i);
        }
        return tmp;
    }
}