import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int n;
    static int r;
    static int m;
    static int k;
    static int x;
    static int[] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]>[] list;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(br.readLine());
            }
            if (n == 1) {
                sb.append(1).append("\n");
                continue;
            }
            for (int j = 2; j <= 1000000; j++) {
                s.clear();
                boolean b = true;
                for (int k = 0; k < n; k++) {
                    if (s.contains(arr[k] % j)) {
                        b = false;
                        break;
                    }
                    s.add(arr[k] % j);
                }
                if (b) {
                    sb.append(j).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }


}