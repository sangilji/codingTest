import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] str = br.readLine().split("");
			Stack<String> stack = new Stack<>();
			if (str[0].equals(".")) {
				break;
			}
			if (!str[str.length - 1].equals(".")) {
				System.out.println("no");
				continue;
			}
			for (String s : str) {
				if (s.equals("[")) {
					stack.add("[");
				} else if (s.equals("]")) {
					if(stack.isEmpty()){
						stack.add("[");
						break;
					}
					if(stack.peek().equals("[")){
						stack.pop();
					} else {
						break;
					}
				} else if (s.equals("(")) {
					stack.add("(");
				} else if (s.equals(")")) {
					if(stack.isEmpty()){
						stack.add("[");
						break;
					}
					if(stack.peek().equals("(")){
						stack.pop();
					} else {
						break;
					}
				}
			}
			if (stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
