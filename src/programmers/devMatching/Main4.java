package programmers.devMatching;

import java.util.HashMap;

public class Main4 {

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] result = new int[enroll.length];
		HashMap<String, String> link = new HashMap<>();
		HashMap<String, Integer> amounts = new HashMap<>();
		for (int i = 0; i < enroll.length; i++) {
			link.put(enroll[i], referral[i]);
		}
		for (int i = 0; i < seller.length; i++) {
			String tmp = seller[i];
			int money = amount[i]*100;
			while (!tmp.equals("-") && money != 0) {

				amounts.put(tmp, (int)(amounts.getOrDefault(tmp, 0) + Math.ceil(money * 0.9)));
				tmp = link.get(tmp);
				money = (int)Math.floor(money * 0.1);
			}
		}
		for(String s : amounts.keySet()){
			System.out.println(s+": amounts.get(s) = " + amounts.get(s));
		}
		for(int i =0;i<result.length;i++){
			System.out.println(enroll[i]);
			result[i]=amounts.getOrDefault(enroll[i],0);
		}
		return result;
	}

	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		Main4 main = new Main4();
		main.solution(enroll, referral, seller, amount);
	}
}
