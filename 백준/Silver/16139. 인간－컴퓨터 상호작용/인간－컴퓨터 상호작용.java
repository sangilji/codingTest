import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[][] arr = new int[s.length()][26];
        for (int i = 0; i < arr.length; i++) {
            int tmp = s.charAt(i) - 'a';
            arr[i][tmp]=1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < 26; j++) {
                arr[i][j] +=arr[i-1][j];
            }
        }
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmp = st.nextToken().charAt(0) - 'a';
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = arr[b][tmp];
            if (a != 0) {
                c -=  arr[a - 1][tmp];
            }
            sb.append(c).append("\n");
        }
        System.out.println(sb);
    }

}