import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"/");
        int a =Integer.parseInt(st.nextToken());
        int b =Integer.parseInt(st.nextToken());
        int c =Integer.parseInt(st.nextToken());
        if(a+c<b || b ==0){
            System.out.println("hasu");
        }else{
            System.out.println("gosu");
        }

    }
}