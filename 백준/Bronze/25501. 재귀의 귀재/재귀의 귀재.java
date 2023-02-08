import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            count = 0;
            String tmp = br.readLine();
            sb.append(isPalindrome(tmp)).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int isPalindrome(String tmp) {
        return recursion(tmp,0,tmp.length()-1);
    }

    private static int recursion(String tmp, int l, int r) {
        count++;
        if (l>=r) return 1;
        else if (tmp.charAt(l)!= tmp.charAt(r)) return 0;
        else return recursion(tmp, l+1,r-1);
    }

}