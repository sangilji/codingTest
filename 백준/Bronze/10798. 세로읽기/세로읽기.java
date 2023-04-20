import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] c = new char[5][];
        for (int i = 0; i < 5; i++) {
            c[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (c[j].length > i) {
                    sb.append(c[j][i]);
                }
            }
        }
        System.out.println(sb);
    }




}