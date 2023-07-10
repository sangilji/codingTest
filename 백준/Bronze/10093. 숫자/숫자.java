import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n == m) {
            System.out.println(0);
            return;
        }
        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m-n-1).append("\n");
        for(int i = n+1 ; i < m ; i++){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}