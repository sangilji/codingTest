import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = bfr.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int basket[] = new int[N + 1];
        int newBasket[] = new int[N + 1];

        for (int s = 1; s <= N; s++) {
            basket[s] = s;
            newBasket[s] = s;
        }

        String method;
        StringTokenizer stt;
        int i, j, k;

        for (int s = 0; s < M; s++) {
            method = bfr.readLine();
            stt = new StringTokenizer(method);
            i = Integer.parseInt(stt.nextToken());
            j = Integer.parseInt(stt.nextToken());
            k = Integer.parseInt(stt.nextToken());
            int ii = i;

            for (int g = 0; g < j - i + 1; g++) {
                if (k + g <= j) {
                    newBasket[g + i] = basket[k + g];
                } else {
                    newBasket[g + i] = basket[ii];
                    ii++;
                }
            }

            for (int g = 1; g <= N; g++) {
                basket[g] = newBasket[g];
            }
        }

        for (int s = 1; s <= N; s++) {
            bfw.write(newBasket[s] + " ");
        }

        bfr.close();
        bfw.flush();
        bfw.close();
    }
}