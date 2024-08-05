import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int gcd(int x, int y){
        if (y == 0) return x;
        return gcd(y, x % y);
    }
    public  static int lcm(int x, int y){
        return x * y / gcd(x,y);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }
}