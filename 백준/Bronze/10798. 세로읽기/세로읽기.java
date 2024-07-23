import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = new String[5];
        for (int i = 0; i < 5; i++) {
            a[i] = sc.next();
        }
        for (int i = 0; i < 15; i++) { 
            for (int j = 0; j < 5; j++) {
                if(a[j].length() > i){ 
                    System.out.print(a[j].charAt(i)); 
                }
            }
        }

    }
}