import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int l;
    static int c;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static String regex = "[aeiou]";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        s = br.readLine().split(" ");

        Arrays.sort(s);
        dfs(0, "", 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, String tmp, int start) {
        if (depth == l) {
            if (check(tmp)) {
                sb.append(tmp).append("\n");
            }
            return;
        }

        for (int i = start; i < c; i++) {
            dfs(depth + 1, tmp + s[i], i + 1);
        }
    }

    private static boolean check(String tmp) {
        int a = 0;
        int b = 0;
        for (String s : tmp.split("")) {
            if (s.matches(regex)) {
                a++;
            } else {
                b++;
            }
        }
        if (a >= 1 && b >= 2) {
            return true;
        }
        return false;
    }
}