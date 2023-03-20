import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static double[][] pos;
    static double[][] nodes;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        pos = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            pos[i][0] = a;
            pos[i][1] = b;
        }


        nodes = new double[(n * n - 1) / 2][3];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <n; j++) {
                nodes[index][0] = i;
                nodes[index][1] = j;
                nodes[index][2] = Math.sqrt(Math.pow(pos[i][0] - pos[j][0],2) + Math.pow(pos[i][1] - pos[j][1],2));
                index++;
            }
        }
        Arrays.sort(nodes, (o1, o2) -> (int) (o1[2] - o2[2]));
        double result = 0;
        int count = 0;
        for (int i = 0; i < nodes.length; i++) {
            int findA = find((int) nodes[i][0]);
            int findB = find((int) nodes[i][1]);

            if (findA!=findB){
                if (findA<findB){
                    parent[findB] = findA;
                } else {
                    parent[findA] = findB;
                }
                result+= nodes[i][2];
                count++;
            }
                if (count==n){
                    break;
                }
        }
        System.out.println(Math.round(result*100)/100.0);
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}