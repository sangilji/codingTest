import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //10개의 숫자를 담을 배열
        int[] arr = new int[10];
        //3번째 큰수를 담을 배열
        int[] results = new int[n];
        //각 배열을 정렬 후 7번째 작은 수 출력(3번째 큰수)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            results[i] = arr[7];
        }
        //출력
        for (int i = 0; i < n; i++) {
            System.out.println(results[i]);
        }
    }
}