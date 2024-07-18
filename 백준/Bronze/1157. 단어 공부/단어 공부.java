import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine().toUpperCase();
        int[] b = new int[26];

        for (int i = 0; i < a.length(); i++) {
            b[a.charAt(i)-65]++;
        }
        int max = 0;
        int index = 0;
        for(int i = 0; i<26; i++){
            if(max<b[i]){
                max = b[i];
                index = i;
            }
        }
        int count = 0;
        for(int i = 0; i<26; i++){
            if(max==b[i]){
                count++;
            }
        }
        if(count >=2){
            System.out.println("?");
        } else {
            System.out.println((char)(index+65));
        }
    }

}