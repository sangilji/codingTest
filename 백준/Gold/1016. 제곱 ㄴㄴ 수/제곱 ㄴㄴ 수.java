import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static long n;
    static long m;
    static int k;

    static int[] arr;
    static long[] tree;
    static double sum;
    static int[] visit;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] arr1;
    static int count = 0;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static int[] result;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());
        arr = new int[1000001];

        for (long i = 2; i * i <= m; i++) {
            long mul = i * i;
            long start;
            if (n > mul) {
                start = mul - (n % mul);
                if (mul == start) {
                    start = 0;
                }
            } else {
                start = mul - n;
            }
            
            for (long j = start; j <= m - n; j += mul) {
                arr[(int) j] = 1;
            }
        }
        for (int i = 0; i <= m - n; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        System.out.println(count);

    }


}