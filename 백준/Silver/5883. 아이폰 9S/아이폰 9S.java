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

    static int[] arr;
    static int[] tree;
    static double sum;
    static int[] visit;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {1, -1, 1, -1};
    static int[] dy = {1, 1, -1, -1};
    static int[] arr1;
    static int count = 0;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static int[] result;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            set.add(arr[i]);
        }

        int result = 0;
        for (int i : set) {
            count = 0;
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    continue;
                }
                if (count == 0) {
                    tmp = arr[j];
                    count++;
                } else if (tmp == arr[j]) {
                    count++;
                } else {
                    result = Math.max(result, count);
                    count = 1;
                    tmp = arr[j];
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);


    }

}