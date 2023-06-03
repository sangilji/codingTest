import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        for(int i=0; i<n; i++){
            String word=br.readLine();
            if(word.length()<m) continue; // 길이가 m 이하인 단어들 제거

            Integer count = wordMap.getOrDefault(word, 0);
            wordMap.put(word, count+1); // <단어, 빈도수> 추가
        }
        List<String> words = wordMap.keySet().stream().collect(Collectors.toList());

        words.sort((o1, o2) -> {
            int c1=wordMap.get(o1);
            int c2=wordMap.get(o2);

            if(c1==c2){
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2); // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에
                }
                return o2.length()-o1.length(); // 해당 단어의 길이가 길수록 앞에
            }
            return c2-c1; // 자주 나오는 단어일수록 앞에
        });

        StringBuilder sb=new StringBuilder();
        for(int i=0; i <words.size(); i++){
            sb.append(words.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}