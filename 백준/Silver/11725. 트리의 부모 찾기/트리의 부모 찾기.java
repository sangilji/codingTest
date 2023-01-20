import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] arr;
    static int[] root;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n+1];
        root = new int[n + 1];
        visit = new boolean[n+1];
        for (int i = 0; i < n + 1; i++) {
            arr[i]= new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        find(1);

        for (int i = 2; i < n+1; i++) {
            System.out.println(root[i]);
        }
    }

    private static void find(int current) {
        visit[current] = true;
        for (int i = 0; i < arr[current].size(); i++) {
            int tmp = arr[current].get(i);
            if (!visit[tmp]) {
                root[tmp] = current;
                find(tmp);
            }
        }
    }

}