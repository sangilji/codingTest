import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] dp;
    static List<Integer>[] list;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new List[1000001];
        for (int i = 0; i <= 1000000; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }
        bfs();


    }

    private static void bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        q.add(new int[]{0, 0, 0});

        Map<Integer, Integer>[] map = new Map[1000001];
        for (int i = 0; i <=1000000; i++) {
            map[i] = new HashMap<>();
        }
        map[0].put(0, 0);
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[1] == m) {
                System.out.println(tmp[2]);
                return;
            }
            for (int i = Math.max(0, tmp[0] - 2); i <= tmp[0] + 2; i++) {
                for (int j = 0; j < list[i].size(); j++) {
                    if (Math.abs(tmp[1]-list[i].get(j)) <= 2){
                        if (map[i].containsKey(list[i].get(j))) {
                            continue;
                        }
                        map[i].put(list[i].get(j), 1);
                        q.add(new int[]{i, list[i].get(j), tmp[2] + 1});
                    }
                }
            }
        }
        System.out.println(-1);
    }


}