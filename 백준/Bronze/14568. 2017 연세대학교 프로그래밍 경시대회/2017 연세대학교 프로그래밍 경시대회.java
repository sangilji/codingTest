import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        int a, b, c;
        int cnt = 0;
        for (a = 1; a < n; a++) {
            for (b = 1; b < n-a; b++) {
                c = n-a-b;
                if(c >= b+2 && a%2!=1 && c!=0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}