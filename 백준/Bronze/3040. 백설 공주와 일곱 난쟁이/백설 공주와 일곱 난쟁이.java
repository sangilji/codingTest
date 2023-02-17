import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int[] arr = new int[9];
    static int sum;
    static boolean[] visit = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sum = -100;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        dfs(0, 0,0);
    }

    private static void dfs(int depth, int s,int count) {
        if (depth == 2) {
            if (sum == s) {
                for (int i = 0; i < 9; i++) {
                    if (!visit[i]) {
                        System.out.println(arr[i]);
                    }
                }
            }
            return;
        }

        for (int i = count; i < 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, s + arr[i],i+1);
                visit[i] = false;
            }
        }
    }
}