package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20040 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        boolean bool = false;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) {
                System.out.println(i + 1);
                bool = true;
                break;
            } else {
                if (parentA < parentB) {
                    parent[parentB] = parentA;
                } else {
                    parent[parentA] = parentB;
                }
            }
        }
        if (!bool) {
            System.out.println(0);
        }

    }

    private static int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent[i]);
    }
}
