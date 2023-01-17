import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        StringBuilder sb = new StringBuilder("IOI");
        for (int i = 0; i < n - 1; i++) {
            sb.append("OI");
        }
        String a = s.next();
        int count = 0;
        for (int i = 0; i <= m - sb.length(); i++) {
            if (a.substring(i, sb.length() + i).equals(sb.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
