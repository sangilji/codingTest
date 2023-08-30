import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
		static String[] num = {"zero","one", "two" , "three" , "four", "five","six", "seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","twenty one","twenty two","twenty three","twenty four","twenty five","twenty six", "twenty seven","twenty eight", "twenty nine"};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int hour = Integer.parseInt(br.readLine());
		int minute = Integer.parseInt(br.readLine());
		cal(hour,minute);


	}

	private static void cal(int hour, int minute) {
		if (minute == 15) {
			System.out.println("quarter past "+num[hour]);
			return;
		}
		if (minute == 30) {
			System.out.println("half past " + num[hour]);
			return;
		}
		if (minute == 45) {
			if (hour == 12) {
				hour =1;
			} else{
				hour++;
			}
			System.out.println("quarter to "+num[hour]);
			return;
		}
		if (minute == 0) {
			System.out.println(num[hour]+ " o' clock");
			return;
		}
		if (minute < 30) {
			System.out.println(num[minute] + " minute" + (minute == 1 ? " past " : "s past ") + num[hour]);
			return;
		}
		if (minute < 60) {
			minute = 60 - minute;
			if (hour == 12) {
				hour =1;
			} else{
				hour++;
			}
			System.out.println(num[minute] + " minute" + (minute == 1 ? " to " : "s to ") + num[hour]);
		}
	}

}