import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken())+arr[i-1];
        }
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i <m ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(arr[b]-arr[a-1]);
        }
    }
}