import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int index = sc.nextInt();
            String str = sc.next();
            
            System.out.println(new StringBuffer(str).deleteCharAt(index-1));
        }
        
        sc.close();
    }
}