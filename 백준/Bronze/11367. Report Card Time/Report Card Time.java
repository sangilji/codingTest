import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt(); // 줄 생성
        int n = 0;
        for (int i = 0; i < line; i++) {
            String a = sc.next(); // 이름 입력
            int b = sc.nextInt();
            if (b <= 59) {
                System.out.println(a + " " + "F");
            } else if (b <= 66) {
                System.out.println(a + " "+ "D");
            } else if (b <= 69) {
                System.out.println(a + " "+ "D+");
            } else if (b <= 76) {
                System.out.println(a + " "+ "C");
            } else if (b <= 79) {
                System.out.println(a + " "+ "C+");
            } else if (b <= 86) {
                System.out.println(a + " "+ "B");
            } else if (b <= 89) {
                System.out.println(a + " "+ "B+");
            } else if (b <= 96) {
                System.out.println(a + " "+ "A");
            } else if(b <= 100){
                System.out.println(a + " "+ "A+");
            }


        }
        sc.close();
    }
}