import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
 
        String str = sc.next(); // 알고리즘 이름을 문자열로 입력받음
 
        for (int i = 0; i < str.length(); i++) { // 문자열의 길이만큼 for문 실행
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') { 
                // 대문자만 출력해야 하므로 if문을 이용해 아스키코드 A이상 Z이하만 출력
                System.out.print(str.charAt(i)); 
                // charAt을 이용해 if문의 조건에 맞는 i번째 문자만 출력
            }
        }
 
    }
}