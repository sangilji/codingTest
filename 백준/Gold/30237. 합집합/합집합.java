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
    static int n;
    static int m;
    static int k;

    static int[][] arr;
    static int[][] sum;
    static int[] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[][][] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            int[] visit = new int[51];
            int max = 0;
            int total = 0;
            Set<Integer>[] set = new Set[51];
            for (int j = 0; j < 51; j++) {
                set[j] = new HashSet<>();
            }
            int[][] arr = new int[n][];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int size = Integer.parseInt(st.nextToken());
                arr[j] = new int[size];
                for (int l = 0; l < size; l++) {
                    arr[j][l] = Integer.parseInt(st.nextToken());
                    if (visit[arr[j][l]] == 0) {
                        total++;
                    }
                    visit[arr[j][l]]++;
                    set[arr[j][l]].add(j);
                }
            }
            for (int j = 1; j <= 50; j++) {
                if (visit[j] != 0) {
                    for (int k : set[j]) {
                        for (int l : arr[k]) {
                            visit[l]--;
                        }
                    }
                    int count = 0;
                    for (int l = 1; l <= 50; l++) {
                        if (visit[l] > 0) {
                            count++;
                        }
                    }
                    if (count != total) {
                        max = Math.max(count, max);
                    }

                    for (int k : set[j]) {
                        for (int l : arr[k]) {
                            visit[l]++;
                        }
                    }
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);


    }


}