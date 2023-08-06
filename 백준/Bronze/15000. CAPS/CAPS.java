import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine(); // 소문자를 입력 받음
                String output = input.toUpperCase(); // 입력받은 소문자를 대문자로 변환
                System.out.println(output);
                sc.close();
        }
}