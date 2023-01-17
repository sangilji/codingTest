import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.next();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char tmp = a.charAt(i);
            switch (tmp) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!st.isEmpty() && priority(st.peek()) >= priority(tmp)) {
                        sb.append(st.pop());
                    }
                    st.push(tmp);
                    break;
                case '(':
                    st.push('(');
                    break;
                case ')':
                    while (st.peek() != '(') {
                        sb.append(st.pop());
                    }
                    st.pop();
                    break;
                default:
                    sb.append(tmp);
                    break;
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb);

    }

    private static int priority(Character c) {
        if (c == '(' || c == ')') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (c == '*' || c == '/') {
            return 2;
        }
        return -1;
    }
}
