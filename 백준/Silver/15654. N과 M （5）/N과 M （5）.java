import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr.add(tmp);
        }
        arr.sort(Integer::compareTo);
        dfs( 0, m,"");
    }

    private static void dfs(int depth, int m, String s) {
        if (depth == m) {
            System.out.println(s);
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (!visit[i]) {
                visit[i]=true;
                dfs( depth + 1, m, s+arr.get(i)+" ");
                visit[i] =false;
            }
        }
    }

}

