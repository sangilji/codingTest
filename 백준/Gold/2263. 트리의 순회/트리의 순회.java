import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] in, post;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        in = new int[n];
        post = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        getPreOrder(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    private static void getPreOrder(int is, int ie, int ps, int pe) {

        if (is <= ie && ps <= pe) {
            sb.append(post[pe]).append(" ");


            int pos = is;
            for (int i = is; i <= ie; i++) {
                if (in[i] == post[pe]) {
                    pos = i;
                    break;
                }
            }
            getPreOrder(is, pos - 1, ps, ps + pos - is - 1);

            getPreOrder(pos + 1, ie, ps + pos - is, pe - 1);
        }


    }

}

