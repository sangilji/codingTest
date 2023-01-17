import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        System.out.println(dfs(a, b, c));
    }

    private static long dfs(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long tmp = dfs(a, b / 2, c);

        if (b % 2 == 1) {
            return (tmp * tmp % c) * a % c;
        }
        return tmp * tmp % c;
    }
}