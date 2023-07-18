import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static int[] parents;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[m][3];
        parents = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parents[i] = i ;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            visit[tmp] = true;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr,Comparator.comparingInt(o->o[2]));
        long sum = 0;
        for (int i = 0; i < m; i++) {
            int a = find(arr[i][0]);
            int b = find(arr[i][1]);
            boolean c = visit[a];
            boolean d = visit[b];
//            System.out.println("i = " + i);
//            System.out.println(Arrays.toString(arr[i]));
//            System.out.println(a+":"+b);
            if (a != b) {
                if (c && d) {
                    continue;
                }
                if (c || d) {
                    visit[a] =true;
                    visit[b] = true;
                }
                if (a < b) {
                   parents[b] = a;
                } else {
                    parents[a] = b;
                }
                sum += arr[i][2];
            }
        }
        System.out.println(sum);
//        System.out.println(Arrays.toString(visit));

    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

}