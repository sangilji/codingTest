import java.util.*;
import java.io.*;
 
 
 
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
       int a=sc.nextInt();
       int b=sc.nextInt();
       
       if(a==b) {System.out.println(a);}
       else {
           if(a>b) {
               System.out.println(a);
           }
           else {
               System.out.println(b);
           }
               
       }
    }
}