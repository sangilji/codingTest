package programmers.devMatching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main6 {
    public String[] solution(String[] record) {
        String[] answer = new String[record.length];
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(":");
            answer[i] = tmp[0];
            List<Integer> tmp2 = Arrays.stream(tmp[1].split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            map.put(answer[i], tmp2);
        }
        Arrays.sort(answer, (o1, o2) -> {
            int o1C = (int) map.get(o1).stream().filter(n -> n != 0).count();
            int o2C = (int) map.get(o2).stream().filter(n -> n != 0).count();
            int sum1 = map.get(o1).stream().mapToInt(n -> n).sum();
            int sum2 = map.get(o2).stream().mapToInt(n -> n).sum();
            if (o1C == o2C) {
                int max1 = 0;
                for (Integer i : map.get(o1)) {
                    if (i != 0) {
                        max1 = Math.max(max1, map.get(o1).indexOf(i));
                    }
                }
                int max2 = 0;
                for (Integer i : map.get(o2)) {
                    if (i != 0) {
                        max2 = Math.max(max1, map.get(o2).indexOf(i));
                    }
                }
                if (max2 == max1) {
                    int gold1 = 0;
                    int silver1 = 0;
                    int bronze1 = 0;
                    for (Integer i : map.get(o1)) {
                        if (Math.ceil(map.size() * 1 / 12) >= i) {
                            gold1++;
                        } else if (Math.ceil(1 / map.size() * 1 / 4) >= i) {
                            silver1++;
                        } else if (Math.ceil(1 / map.size() * 1 / 2) <= i) {
                            bronze1++;
                        }
                    }
                    int gold2 = 0;
                    int silver2 = 0;
                    int bronze2 = 0;
                    for (Integer i : map.get(o2)) {
                        if (Math.ceil(map.size() * 1 / 12) <= i) {
                            gold2++;
                        } else if (Math.ceil(1 / map.size() * 1 / 4) <= i) {
                            silver2++;
                        } else if (Math.ceil(1 / map.size() * 1 / 2) <= i) {
                            bronze2++;
                        }
                    }
                    if (gold1 == gold2) {
                        if (silver1 == silver2) {
                            if (bronze1 == bronze2) {
                                if (sum1 == sum2) {
                                    return o1.compareTo(o2);
                                }
                                return sum2 - sum1;
                            }
                            return bronze2 - bronze1;
                        }
                        return silver2 - silver1;
                    }
                    return gold2 - gold1;
                }
                return max2 - max1;
            }
            return o2C - o1C;
        });
        return answer;
    }

    public static void main(String[] args) {
        Main6 m = new Main6();
        m.solution(new String[]{"jack:9,10"});
    }
}
