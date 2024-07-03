import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] dp;
    static List<Integer>[] list;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String tmp = br.readLine();
        n = tmp.length();
        arr = new int[n];
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i)=='(') {
                arr[i] = 1;
            }else{
                arr[i] = -1;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            count += arr[i];
            if (count == -1) {
                result++;
                count=0;
            }
        }
        result+=count;
        System.out.println(result);
        

    }


}