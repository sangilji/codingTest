import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken()) + 1;
        int x;
        if (h % n == 0) {
            x = h / n;
        } else {
            x = h / n + 1;
        }
        int y;
        if (w % m == 0) {
            y = w / m;
        } else {
            y = w / m + 1;
        }
        System.out.println(x * y);
    }
}