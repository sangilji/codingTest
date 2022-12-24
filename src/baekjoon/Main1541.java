package baekjoon;

import java.util.Scanner;

public class Main1541 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String x = s.next();
		int start = 0;
		int result = 0;
		boolean b = false;
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == '+') {
				if (b) {
					result -= Integer.parseInt(x.substring(start, i));
					start = i+1;
					continue;
				}
				result += Integer.parseInt(x.substring(start, i));
				start = i+1;
			} else if (x.charAt(i) == '-') {
				if (b) {
					result -= Integer.parseInt(x.substring(start, i));
					start = i+1;
					continue;
				}
				result += Integer.parseInt(x.substring(start, i));
				start = i+1;
				b = true;
			}
		}
		if (b){
			result -= Integer.parseInt(x.substring(start));
		} else {
			result += Integer.parseInt(x.substring(start));
		}
		System.out.println(result);
	}
}
