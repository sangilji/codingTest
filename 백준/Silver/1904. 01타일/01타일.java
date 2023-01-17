

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int tmp1=2;
        int tmp2=3;
        int tmp = 0;
        if(n==1) {
            tmp =1;
        } else if(n==2) {
            tmp=2;
        } else if(n==3) {
            tmp=3;
        } else {
        for(int i=4;i<=n;i++) {
          tmp=(tmp1+tmp2)%15746;
          tmp1=tmp2%15746;
          tmp2=tmp%15746;
        }
    }
        System.out.println(tmp);
        
    }
}
