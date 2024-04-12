import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int star = scanner.nextInt();

     // 첫번째 for문
    for(int i = 1 ; i <= star; i++) {
      //공백찍기
      for(int j = 1; j < i; j++) {
        System.out.print(" ");
      }
      //별찍기
      for(int k = (2*star)-(i*2-1); k > 0; k--) {
        System.out.print("*");
      }
      System.out.println();
    }
    scanner.close();
  }
}