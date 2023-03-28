import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static boolean[] visit = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bfs(n);

    }

    private static void bfs(int n) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (visit[tmp[0]]) {
                continue;
            }
            visit[tmp[0]]=true;

            if (tmp[0]==1){
                System.out.println(tmp[1]);
                return;
            }
            if (tmp[0] % 3 == 0) {
                q.add(new int[]{tmp[0]/3, tmp[1]+1});
            }
            if (tmp[0] % 2 == 0) {
                q.add(new int[]{tmp[0]/2, tmp[1]+1});
            }
            q.add(new int[]{tmp[0]-1, tmp[1]+1});
        }
    }
}