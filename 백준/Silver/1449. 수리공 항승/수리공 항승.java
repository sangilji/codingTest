import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        // 2개의 수를 받는다.
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int tapeLength = sc.nextInt();

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }

		// 파이프 정렬 
        Arrays.sort(arr);

        int temp = 0;
        int result = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > temp) {
                result++;
                temp = arr[i];
                // 구멍이 1이고 테이프길이가 2일 경우 
                // 1 + 2 = 3 <- 테이프는 1부터2까지 막을 수 있으므로 
                // 1을 빼준다. 
                temp += tapeLength - 1;
            }
        }

        System.out.println(result);
    }
}