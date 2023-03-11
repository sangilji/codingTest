import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> arr;
    static boolean[] visit;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
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
        dfs(0, m,"");
        for (String s : set){
            System.out.println(s);
        }
    }

    private static void dfs(int depth, int m, String s) {
        if (depth == m) {
            set.add(s);
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

