import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n==1 || n ==0){
            System.out.println(n);
            return;
        }

        n--;
        long[][] matrix = {{1,1},{1,0}};
        long[][] tmp = {{1,0},{0,1}};

        while (n>0){
            if (n%2==1){
                tmp = multy(tmp, matrix);
            }
            matrix = multy(matrix, matrix);
            n/=2;
        }

        System.out.println(tmp[0][0]);
    }

    private static long[][] multy(long[][] matrix, long[][] matrix1) {

        long[][] tmp = new long[2][2];
        tmp[0][0] = ((matrix[0][0]*matrix1[0][0]) +(matrix[0][1]*matrix1[1][0]))%1000000007;
        tmp[0][1] = ((matrix[0][0]*matrix1[0][1]) +(matrix[0][1]*matrix1[1][1]))%1000000007;
        tmp[1][0] = ((matrix[1][0]*matrix1[0][0]) +(matrix[1][1]*matrix1[1][0]))%1000000007;
        tmp[1][1] = ((matrix[1][0]*matrix1[0][1]) +(matrix[1][1]*matrix1[1][1]))%1000000007;

        return tmp;
    }


}
