package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1167 {
    static ArrayList<int[]>[] nodes;
    static boolean[] visit;
    static int longNode;
    static int max = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        nodes = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            int node = s.nextInt();
            while (true) {
                int otherNode = s.nextInt();
                if (otherNode == -1) {
                    break;
                }
                int cost = s.nextInt();
                nodes[node].add(new int[]{otherNode, cost});
            }
        }
        visit = new boolean[v + 1];
        visit[1] = true;
        dfs(1, 0);
        visit = new boolean[v + 1];
        visit[longNode] = true;
        dfs(longNode, 0);
        System.out.println(max);
    }

    private static void dfs(int x, int sum) {
        if (max < sum) {
            max = sum;
            longNode = x;
        }

        for (int i = 0; i < nodes[x].size(); i++) {
            if (!visit[nodes[x].get(i)[0]]) {
                visit[nodes[x].get(i)[0]] = true;
                dfs(nodes[x].get(i)[0], sum + nodes[x].get(i)[1]);
            }
        }
    }
}

