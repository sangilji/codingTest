import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Ur = Integer.parseInt(st.nextToken());
        int Tr = Integer.parseInt(st.nextToken());
        int Uo = Integer.parseInt(st.nextToken());
        int To = Integer.parseInt(st.nextToken());
        System.out.print(56*Ur + 24*Tr + 14*Uo + 6 *To);
    }
}