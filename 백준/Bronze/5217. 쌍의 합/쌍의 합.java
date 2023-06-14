import java.util.*;
import java.io.*;
 
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
       int n=sc.nextInt();
       int sw=0;
       
       for(int i=0;i<n;i++) {
           String temp="Pairs for ";
           int input=sc.nextInt();
           int a=1; int b=1;
           System.out.print(temp+input+':');          
           for(int j=1;j<input;j++) {
               for(int k=j+1;k<input;k++) {
                   if(j<k && j!=k && j+k==input &&sw==0) {
                       System.out.print(" "+j+" "+k);
                       sw=1;}
                   else if(j<k && j!=k && j+k==input &&sw==1) {
                           System.out.print(", "+j+" "+k);
                           sw=1;  
                   }
               }
           }
           sw=0;
           System.out.println();
       }
       
}
}