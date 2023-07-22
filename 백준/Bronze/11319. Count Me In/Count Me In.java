import java.util.*;
import java.io.*;
 
 
 
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
       int n=sc.nextInt();
       int jaum=0;
       int moum=0;
       
       for(int i=0;i<=n;i++) {
           String input =sc.nextLine().trim().toLowerCase().replaceAll(" ","");
           for(int j=0;j<input.length();j++) {
               if(input.charAt(j)=='a'||input.charAt(j)=='e'||input.charAt(j)=='i'||input.charAt(j)=='o'||input.charAt(j)=='u') {
                   moum++;
               }
               else {
                   jaum++;
               }               
           }
           if(jaum!=0 &&moum!=0) {
           System.out.println(jaum+" "+moum);
           jaum=0;moum=0;
       }
       }
    }
}