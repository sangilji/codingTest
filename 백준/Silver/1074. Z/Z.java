import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        find((int) Math.pow(2, n), r, c);

        System.out.println(result);
    }

    private static void find(int n, int x, int y) {
        if (n == 1) {
            return;
        }

        int nextSize = n / 2;
        if (nextSize > x && nextSize > y) {
            find(nextSize, x, y);
        } else if (nextSize <= x && nextSize > y) {
            result += nextSize * nextSize * 2;
            find(nextSize, x - nextSize, y);
        } else if (nextSize > x && nextSize <= y) {
            result += nextSize * nextSize;
            find(nextSize, x, y - nextSize);
        } else {
            result += nextSize * nextSize * 3;
            find(nextSize, x - nextSize, y - nextSize);
        }
    }
}