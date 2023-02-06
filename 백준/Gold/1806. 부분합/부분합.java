import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int a = 0;
        if (numbers[a]>=s){
            System.out.println(1);
            return;
        }
        if (Arrays.stream(numbers).sum()<s){
            System.out.println(0);
            return;
        }
        int sum = numbers[a];
        int len = 100001;
        for (int i = 1; i < n; i++) {
            sum += numbers[i];
            if (sum >= s) {
                while (sum>=s){
                    sum -= numbers[a++];
                }
                len = Math.min(len,i-a+2);
            }
        }
        System.out.println(len);
    }





}
