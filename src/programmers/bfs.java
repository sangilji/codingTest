package programmers;

import java.util.*;
import java.util.Map.Entry;

public class bfs {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        int c = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, ArrayList<int[]>> ind = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (hm.containsKey(genres[i])) {
                hm.put(genres[i], hm.get(genres[i]) + plays[i]);
            } else {
                hm.put(genres[i], plays[i]);
                ind.put(genres[i], new ArrayList<>());

            }
            ind.get(genres[i]).add(new int[]{plays[i], i});
        }

        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        for (Entry<String, Integer> entry : list_entries) {
            int[][] tmp = new int[ind.get(entry.getKey()).size()][2];
            for (int i = 0; i < ind.get(entry.getKey()).size(); i++)
                tmp[i] = ind.get(entry.getKey()).get(i);
            Arrays.sort(tmp, (o2, o1) -> {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            });
            answer.add(tmp[0][1]);
            if (tmp.length > 1)
                answer.add(tmp[1][1]);
        }
        return answer;
    }

    public static void main(String[] args) {
        bfs b = new bfs();
        String[] genres = {"a", "b", "c", "d", "a", "d", "d", "d", "a", "a", "c", "c"};
        System.out.println(Arrays.asList(genres).indexOf("c"));
        int[] plays = {100, 300, 400, 150, 100, 300, 200, 600, 700, 110, 900, 9000};
        ArrayList<Integer> re = b.solution(genres, plays);
//        for(Integer i : re){
//            System.out.println(i);
//        }

    }
}
