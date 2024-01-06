import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] c = new int[s.length()];
        int n = 0;
        for (int i = 0 ; i < s.length(); i++) {
            c[i] = s.charAt(i) - '0';
        }
        for (int i = 0 ; i < c.length; i++) {
            n += Math.pow(c[i], 5);
        }
        System.out.println(n);
    }
}