import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

//        for (int i = 0; i < aa.length; i++) {
//            System.out.print(a[aa[i][0]]+a[aa[i][1]] + ", ");
//        }
        int[] arr = new int[3];
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n-2; i++) {
            int first = i + 1;
            int last = a.length-1;
            while (first<last) {
                int b = a[first];
                int c = a[last];
                if ((long)a[i]+b+c < 0) {
                    first++;
                } else {
                    last--;
                }
                long abs = Math.abs((long)a[i] + b + c);
                if (abs < result) {
                    result = abs;
                    arr[0] = a[i];
                    arr[1] = b;
                    arr[2] = c;
                }
            }
        }

        Arrays.sort(arr);
        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i]+" ");
        }

    }




}