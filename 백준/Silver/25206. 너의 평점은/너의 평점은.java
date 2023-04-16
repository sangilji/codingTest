import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        double sum = 0;
        String[] tmp;
        for (int i = 0; i < 20; i++) {
            tmp = br.readLine().split(" ");
            double a = Double.parseDouble(tmp[1]);
            if (tmp[2].equals("P")) {
                continue;
            } else if (tmp[2].equals("A+")) {
                sum += a * 4.5;
            } else if (tmp[2].equals("A0")) {
                sum += a * 4.0;
            } else if (tmp[2].equals("B+")) {
                sum += a * 3.5;
            } else if (tmp[2].equals("B0")) {
                sum += a * 3.0;
            } else if (tmp[2].equals("C+")) {
                sum += a * 2.5;
            } else if (tmp[2].equals("C0")) {
                sum += a * 2.0;
            } else if (tmp[2].equals("D+")) {
                sum += a * 1.5;
            } else if (tmp[2].equals("D0")) {
                sum += a;
            }
            count += a;
        }
        System.out.println(sum / count);
    }


}