import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String result = "";
 
        int[] arr = {300, 60, 10};
        int T = Integer.parseInt(str);
 
        if (T % 10 != 0) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < arr.length; i++) {
                result += T / arr[i]+" ";
                T %= arr[i];
            }
            System.out.println(result);
        }
    }
}