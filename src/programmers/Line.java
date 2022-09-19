package programmers;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        List<Integer> arr = new ArrayList<>();
        int[] answer = new int[n];
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            arr.add(i);
        }
        k--;
        int count = 0;
        for (int i = n; i > 0; i--) {
            factorial /= i;
            answer[count++] = arr.get((int) (k / factorial));
            arr.remove((int) (k / factorial));
            k %= factorial;
        }

    }
}
