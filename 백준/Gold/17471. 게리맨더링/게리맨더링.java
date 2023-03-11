import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static List<Integer>[] list;
    static boolean[] visit;
    static int n;
    static int[] population;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        population = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                list[i].add(tmp);
            }
        }
        dfs(0, 1);
        if (Integer.MAX_VALUE == min){
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    private static void dfs(int depth, int start) {
        if (depth > n / 2) {
            return;
        }
        check();
        for (int i = start; i < n + 1; i++) {
            visit[i] = true;

            dfs(depth + 1, i + 1);
            visit[i] = false;
        }
    }

    private static void check() {

        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (visit[i]){
                count++;
            }
        }
        if (count == 0 || count == n){
            return;
        }
//        System.out.println(Arrays.toString(visit));

        for (int i = 1; i < n+1; i++) {
            if (visit[i]){
                q.add(i);
                break;
            }
        }

        boolean[] checked = new boolean[n + 1];
        checked[q.peek()]= true;
        while (!q.isEmpty()) {
            int tmp = q.poll();

            for (Integer i : list[tmp]){
                if (!visit[i] || checked[i]){
                    continue;
                }
                checked[i] = true;
                q.add(i);
            }
        }

        for (int i = 1; i < n+1; i++) {
            if (checked[i] != visit[i]){
                return;
            }
        }

        for (int i = 1; i < n+1; i++) {
            if (!visit[i]){
                q.add(i);
                break;
            }
        }
        checked = new boolean[n + 1];
        checked[q.peek()]= true;
        while (!q.isEmpty()) {
            int tmp = q.poll();

            for (Integer i : list[tmp]){
                if (visit[i] || checked[i]){
                    continue;
                }
                checked[i] = true;
                q.add(i);
            }
        }

        for (int i = 1; i < n+1; i++) {
            if (checked[i] == visit[i]){
                return;
            }
        }

        findMin();
    }

    private static void findMin() {

        int a = 0;
        int b = 0;
        for (int i = 1; i < n+1; i++) {
            if (visit[i]){
                a+=population[i];
            } else {
                b += population[i];
            }
        }
        int tmp = Math.abs(a - b);

        min = Math.min(tmp, min);
    }


}