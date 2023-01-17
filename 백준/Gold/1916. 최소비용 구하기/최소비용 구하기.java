import java.util.*;

public class Main {
    static ArrayList<int[]>[] nodes;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m =s.nextInt();
        nodes = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int cost = s.nextInt();
            nodes[a].add(new int[]{b, cost});
        }
        int a = s.nextInt();
        int b= s.nextInt();
        dijk(a,b,n);
    }

    private static void dijk(int a, int b, int n) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        boolean[] visit = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        q.add(new int[]{a,0});
        dist[a]=0;

        while (!q.isEmpty()){
            int tmp = q.poll()[0];

            if (visit[tmp]){
                continue;
            }
            visit[tmp]= true;

            for (int[] next : nodes[tmp]) {
                if (dist[next[0]]> dist[tmp] + next[1]){
                    dist[next[0]]= dist[tmp] + next[1];


                    q.add(new int[]{next[0],dist[next[0]]});
                }
            }
        }
        System.out.println(dist[b]);
    }

}
