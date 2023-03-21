import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] parent;
    static int n;
    static boolean[] visit;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        visit = new boolean[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[][] lines = new int[n][4];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                lines[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = lines[i][0];
                int y1 = lines[i][1];
                int x2 = lines[i][2];
                int y2 = lines[i][3];
                int x3 = lines[j][0];
                int y3 = lines[j][1];
                int x4 = lines[j][2];
                int y4 = lines[j][3];
                int tmp1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
                int tmp2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);
                if (tmp1 <= 0 && tmp2 <= 0 && check(lines[i], lines[j])) {
                    int findA = find(i);
                    int findB = find(j);
                    if (findA != findB) {
                        if (findA < findB) {
                            parent[findB] = findA;
                        } else {
                            parent[findA] = findB;
                        }
                    }
                }
            }
        }
        int result= 0;
        for (int i = 0; i < n; i++) {
            find(i);
        }
        for (int i = 0; i < n; i++) {
            int tmp = parent[i];
            count[tmp]++;
            if (!visit[tmp]){
                visit[tmp] = true;
                result++;
            }
        }

        System.out.println(result);
        System.out.println(Arrays.stream(count).max().getAsInt());

    }

    private static boolean check(int[] line, int[] line1) {
        int a;
        int b;
        int c;
        int d;

        if (line[0] == line[2]) {
            a = Math.max(line[1], line[3]);
            b = Math.min(line[1], line[3]);
            c = Math.max(line1[1], line1[3]);
            d = Math.min(line1[1], line1[3]);

        } else {
            a = Math.max(line[0], line[2]);
            b = Math.min(line[0], line[2]);
            c = Math.max(line1[0], line1[2]);
            d = Math.min(line1[0], line1[2]);
        }
        if (a<c){
            if (a>=d){
                return true;
            } else {
                return false;
            }
        } else if (a==c){
            return true;
        } else {
            if (b<=c){
                return true;
            } else {
                return false;
            }
        }
    }

    private static boolean match(int[] line, int[] line1) {
        if ((line[0] == line1[0] && line[1] == line1[1]) ||
                (line[0] == line1[2] && line[1] == line1[3])
                || (line[2] == line1[0] && line[3] == line1[1])
                || (line[2] == line1[2] && line[3] == line1[3])) {
            return true;
        }
        return false;
    }

    private static int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long op = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (op > 0) {
            return 1;
        }
        if (op == 0) {
            return 0;
        }
        return -1;
    }

}