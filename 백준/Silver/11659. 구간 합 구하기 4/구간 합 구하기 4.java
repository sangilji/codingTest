import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] map = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j < n + 1; j++) {
            map[j] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j < n + 1; j++) {
            map[j] += map[j - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = map[b] - map[a-1];

            sb.append(sum).append("\n");

        }
        System.out.println(sb);
    }
}