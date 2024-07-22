import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        int[] arr = new int[a];
        double max = 0;
        double avg = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = b = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            avg += (arr[i]/max)*100;
        }
        System.out.println(avg/a);


    }
}