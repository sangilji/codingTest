import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static int INF = 1_000_000_007;
    static int MOD = 1_000_000_007;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int[] arr2;
    static int[] costs;
    static int[] visit;
    static int[] sz;
    static int[] depth;
    static int[] parent;
    static int[] top;
    static int[] in;
    static int[] out;
    static long[] tree_min;
    static long[] tree_max;
    static List<Integer>[] list;
    static List<int[]>[] graph;
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {1, 1, 0, -1};
    static int[][] arr1;
    static int count = 0;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Set<Integer> s = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        arr1 = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
            s.add(arr1[i][0] - 1);
            s.add(arr1[i][0] + 1);
            s2.add(arr1[i][1] - 1);
            s2.add(arr1[i][1] + 1);
        }
        List<Integer> list = s.stream().sorted().collect(Collectors.toList());
        List<Integer> list2 = s2.stream().sorted().collect(Collectors.toList());

        long result = Long.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int side = list.get(j) - list.get(i);

                for (int tmp : list2) {
                    if (find(list.get(i), list.get(j), tmp, tmp + side)) {
                        result = Math.min(result, (long) side * side);
                    }
                    if (find(list.get(i), list.get(j), tmp - side, tmp)) {
                        result = Math.min(result, (long) side * side);
                    }
                }
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            for (int j = i + 1; j < list2.size(); j++) {
                int side = list2.get(j) - list2.get(i);
                for (int tmp : list) {
                    if (find(tmp, tmp + side, list2.get(i), list2.get(j))) {
                        result = Math.min(result, (long) side * side);
                    }
                    if (find(tmp - side, tmp, list2.get(i), list2.get(j))) {
                        result = Math.min(result, (long) side * side);
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static boolean find(int x, int x2, int y, int y2) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (x < arr1[i][0] && x2 > arr1[i][0] && y < arr1[i][1] && y2 > arr1[i][1]) {
                count++;
            }
            if (count >= m) {
                return true;
            }
        }
        return false;
    }


}