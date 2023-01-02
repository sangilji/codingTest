package swea;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1248 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int number1 = sc.nextInt();
            int number2 = sc.nextInt();
            int[][] tree = new int[V + 1][2];
            for (int i = 0; i < E; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (tree[a][0] != 0) {
                    tree[a][1] = b;
                } else {
                    tree[a][0] = b;
                }
            }
            int[] score = new int[tree.length];
            find(tree, number1, number2, 1, score);
            int num = 0;
            int min = 10001;
            for (int i = 0; i < V; i++) {
                if (score[i] == 2) {
                    int tmp = bfs(tree, num);
                    if (min > tmp) {
                        num = i;
                        min = tmp;
                    }
                }
            }
            System.out.printf("#%d %d %d\n", test_case, num, min);
        }
    }

    private static int bfs(int[][] tree, int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        int count = 1;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (tree[tmp][0] != 0) {
                q.add(tree[tmp][0]);
                count++;
            }
            if (tree[tmp][1] != 0) {
                q.add(tree[tmp][1]);
                count++;
            }
        }
        return count;
    }

    private static int find(int[][] tree, int number1, int number2, int current, int[] score) {
        if (current == number1 || current == number2) {
            return 1;
        }
        if (current == 0) {
            return 0;
        }
        score[current] += find(tree, number1, number2, tree[current][0], score);
        score[current] += find(tree, number1, number2, tree[current][1], score);
        return score[current];
    }
}
