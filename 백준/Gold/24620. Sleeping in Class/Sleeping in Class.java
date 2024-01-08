import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static final int INF = 1_000_000_000;
    static int n;
    static int m;
    static List<Integer>[] list;
    static int[] parent;
    static int[] score;
    static int[] cards;
    static int[] arr;
    static int[][][] dp;
    static int[] sz;
    static int[] visit;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int t = 0; t < n; t++) {
            m = Integer.parseInt(br.readLine());
            arr = new int[m];
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            if (sum == 0) {
                sb.append(0).append("\n");
                continue;
            }
            Set<Integer> s = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            int tmp = sum;
            for (int i = 2; i <= Math.sqrt(sum); i++) {
                while (tmp % i == 0) {
                    list.add(i);
                    tmp /= i;
                }
            }
            if (tmp != 1) {
                list.add(tmp);
            }
            makeSet(0, 1, list, s);
            List<Integer> list1 = s.stream().sorted().collect(Collectors.toList());
            for (int i : list1) {
                int tmp2 = 0;
                int count = sum / i;
                if (count > m) {
                    continue;
                }
                boolean b = true;
                for (int j = 0; j < m; j++) {
                    tmp2 += arr[j];
                    if (tmp2 == i) {
                        tmp2 = 0;
                    } else if (tmp2 > i) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    sb.append(m - count).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);

    }

    private static void makeSet(int depth, int mul, List<Integer> list, Set<Integer> set) {
        if (list.size() == depth) {
            set.add(mul);
            return;
        }
        makeSet(depth + 1, mul * list.get(depth), list, set);
        makeSet(depth + 1, mul, list, set);

    }

}