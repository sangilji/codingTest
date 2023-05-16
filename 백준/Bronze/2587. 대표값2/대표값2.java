import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;  //수들의 합
        int mid = 0;  //중앙값
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);  //배열 오름차순으로 정렬
        int avg = sum / 5;  //평균 구하기
        mid = arr[2];
        System.out.print(avg + "\n" + mid);
    }
}