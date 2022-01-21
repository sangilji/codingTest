import java.util.*;

public class Coding {

    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for (char x : str.toCharArray()) {
            answer++;
        }
        return answer;
    }

    public class Code {

    }

    public static void main(String[] args) {
        Coding c = new Coding();
        Scanner s = new Scanner(System.in);
        String str = s.next();
        char t = s.next().charAt(0);
        System.out.print(c.solution(str, t));


    }
}
