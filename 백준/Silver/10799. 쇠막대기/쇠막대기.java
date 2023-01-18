import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        //코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int stackSize = 0;
        int current = 0;
        int result = 0;
        while (current<n.length()){
            if (n.charAt(current) == '('){
                if (n.charAt(current+1) == ')'){
                    result+=stackSize;
                    current+=2;
                    continue;
                }
                stackSize++;
            } else {
                stackSize--;
                result++;
            }
            current++;
        }
        System.out.println(result);
    }
}