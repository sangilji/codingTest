import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static int n;
    static int m;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        numbers = new int[m];
        combi(0, 0);
    }

    public static void combi(int depth, int start) {
        if (depth == m) {
            System.out.println(Arrays.stream(numbers)
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
            return;
        }

        for (int i = start; i < n; i++) {
            numbers[depth] = i + 1;
            combi(depth + 1, i + 1);
        }
    }
}