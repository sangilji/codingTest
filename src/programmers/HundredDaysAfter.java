package programmers;

import java.util.Calendar;

public class HundredDaysAfter {
    public String hundredDaysAfter() {
        //오늘부터 100일 뒤의 날짜를 "2016년1월1일"의 형식으로 return하세요.
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 100);
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DATE);

        return y + "년" + m + "월" + d + "일";
    }

    public static void main(String[] args) {
        HundredDaysAfter l = new HundredDaysAfter();
        String h = l.hundredDaysAfter();
        System.out.println(h);
    }
}
