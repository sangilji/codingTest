import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// KMP 알고리즘(Knuth–Morris–Pratt Algorithm)
// O(N+M)

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] text = in.readLine().toCharArray();
        char[] pattern = in.readLine().toCharArray();

        int tLength = text.length, pLength = pattern.length;

        int[] pi = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];

            if (pattern[i] == pattern[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        // i : 텍스트 포인터 , j: 패턴 포인터
        for (int i = 0, j = 0; i < tLength; ++i) {

            while (j > 0 && text[i] != pattern[j]) j = pi[j - 1];

            if (text[i] == pattern[j]) { //두 글자 일치
                if (j == pLength - 1) { // j가 패턴의 마지막 인덱스라면
                    cnt++; // 카운트 증가
                    list.add(i - j);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)+1).append(" ");
        }
        System.out.println(sb);
    }
}