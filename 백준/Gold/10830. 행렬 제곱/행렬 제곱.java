
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static long[][] matrix;

    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        matrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        long[][] tmp = merge(b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tmp[i][j]%1000 + " ");
            }
            System.out.println();
        }
    }

    private static long[][] merge(long b) {
        if (b == 1) {
            return matrix;
        }
        long[][] temp = merge(b / 2);

        if (b % 2 == 0) {
            return mul(temp, temp);
        }
        return mul(mul(temp, temp), matrix);
    }

    public static long[][] mul(long[][] mat1, long[][] mat2) {
        long[][] mat = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[i][j] = (mat[i][j] + mat1[i][k] * mat2[k][j]) % 1000;
                }
            }
        }
        return mat;
    }
}
