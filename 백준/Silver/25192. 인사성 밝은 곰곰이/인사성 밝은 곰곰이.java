import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> hashSet = new HashSet<>();

        int cnt = 0;

       while (N-- > 0) {

           String person = br.readLine();

           if(person.equals("ENTER")) {
               hashSet = new HashSet<>();
               continue;
           }

           if(!hashSet.contains(person)) {
               hashSet.add(person);
               cnt++;
           }
       }
        System.out.println(cnt);
    }
}