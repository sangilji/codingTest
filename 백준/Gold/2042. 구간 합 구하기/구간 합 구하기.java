import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n + 1];
        tree = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Long.parseLong(br.readLine());
            add(i, arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (command == 1) {
                add(a,b-arr[a]);
                arr[a] = b;
            } else {
                sb.append(sum((int)b) - sum(a - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void add(int i, long num) {
        while (i <= n) {
            tree[i] += num;
            i += (i & -i);
        }
    }

    public static long sum(int i) {
        long tmp = 0;
        while (i > 0) {
            tmp += tree[i];
            i -= (i & -i);
        }
        return tmp;
    }
}