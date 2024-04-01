import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int sum;
    static int[] visit;
    static int[] parent;
    static int[] size;
    static int[] min;
    static int[] max;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr1;
    static int count = 0;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<Integer>[] list;
    static List<Integer>[] list2;

    static int[] result;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        Directory directory = new Directory();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            directory.add(a, st);
        }

        print(directory, 0);
        System.out.println(sb);
    }

    private static void print(Directory directory, int depth) {
        for (String tmp : directory.map.keySet()) {
            for (int i = 0; i < depth; i++) {
                sb.append("--");
            }
            sb.append(tmp).append("\n");
            print(directory.map.get(tmp), depth + 1);
        }
    }

    static class Directory {
        Map<String, Directory> map = new TreeMap<>(String::compareTo);

        public void add(int num, StringTokenizer st) {
            Directory tmp = this;

            for (int i = 0; i < num; i++) {
                String a = st.nextToken();
                if (!tmp.map.containsKey(a)) {
                    tmp.map.put(a, new Directory());
                }
                tmp = tmp.map.get(a);
            }
        }
    }


}