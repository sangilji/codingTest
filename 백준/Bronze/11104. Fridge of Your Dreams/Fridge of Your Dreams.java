import java.util.*;
import java.io.*;
 
 
 
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
       int n=sc.nextInt();
       Long result=(long) 0;       
       Long cnt =(long) 1;
       
       for(int i=0;i<n;i++) {
               String [] arr =sc.next().split("");
                           
               for(int j=23;j>=0;j--) {
                   result+= Integer.parseInt(arr[j])*cnt;
                           cnt*=2;
               }
               System.out.println(result);
               cnt=(long)1;
               result=(long)0;
       }
    }
}