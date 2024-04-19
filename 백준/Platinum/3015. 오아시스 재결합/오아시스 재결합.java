import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
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
        n = Integer.parseInt(br.readLine());
        Stack<int[]> s = new Stack<>();
        long result = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            int c = 1;
            if (s.isEmpty()) {
                s.push(new int[]{tmp, 1});
            } else {
                while (!s.isEmpty()) {
                    int[] top = s.peek();
                    if (top[0] < tmp) {
                        result += top[1];
                        s.pop();
                    } else if (top[0] == tmp) {
                        result += top[1];
                        c += top[1];
                        s.pop();
                    } else {
                        break;
                    }

                }
                if (!s.isEmpty()) {
                    result++;
                }
                s.push(new int[]{tmp, c});
            }
        }
        System.out.println(result);
    }


}
/* 9 + 8
10
10
9
1
3
8
6
7
8
5
8
 */