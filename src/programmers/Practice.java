package programmers;

import java.util.*;

public class Practice {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[][] infoSet = new String[info.length][5];
        String[][] querySet = new String[query.length][5];
        for (int i = 0; i < info.length; i++) { //세팅
            infoSet[i] = info[i].split(" ");
            querySet[i] = query[i].split(" and ");
        }
        int[] count = new int[5];
        int minimum;
        for (int i = 0; i < querySet.length; i++) {
            minimum = info.length;
            for (int j = 0; j < 5; j++) {
                count[j] = 0;
                if (querySet[i][j].equals("-")) {
                    count[j] = info.length;
                    continue;
                }
                for (int k = 0; k < infoSet.length; k++) {
                    if (querySet[i][j].equals(infoSet[k][j]))
                        count[j]++;

                }
                minimum = Math.min(count[j], minimum);
            }
            answer[i] = minimum;
        }

        return answer;
    }

    public int[][] solution1(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[Math.max(arr1.length, arr2.length)][Math.max(arr1[0].length, arr2[0].length)];
        for (int i = 0; i < answer.length; i++)
            for (int j = 0; j < answer[i].length; j++) {
                for (int k = 0; k < answer[i].length; k++) {
                    answer[i][j] += arr1[i][arr1[i].length - k] * arr2[arr2[i].length - k][j];
                }
            }
        return answer;
    }

    public String solution2(int n) {
        String answer = "";
        while (n / 3 > 0) {
            answer += n % 3;
            n /= 3;
        }
        return answer;
    }

    public int solution3(int[] priorities, int location) {
        int answer = 0;
        int tmp = location;
        HashSet<Integer> hs = new HashSet<>();
        for (int i : priorities)
            hs.add(i);
        int[] priority = new int[hs.size()];
        Iterator<Integer> it = hs.iterator();
        int x = 0;
        while (it.hasNext())
            priority[x++] = it.next();
        Arrays.sort(priority);
        int top = priority.length - 1;
        Queue<Integer> queue = new LinkedList<>();
        int k = priorities.length - 1;
        for (int i : priorities)
            queue.offer(i);
        System.out.println(queue.size());

        while (true) {
            if (queue.peek() == priority[top]) {
                queue.poll();
                top--;
                k--;
                answer++;
                if (tmp == location)
                    break;
            } else {
                queue.offer(queue.poll());
                location--;
            }
            if (location < 0) {
                location = k;
            }
        }
        return answer;
    }

    public String solution4(int[] numbers) {
        Arrays.sort(numbers);
        String answer = "" + numbers[0];
        String m;
        for (int i = 1; i < numbers.length; i++) {
            m = answer;
            for (int j = 0; j < i; j++) {

                String tmp1 = answer.replace(String.valueOf(numbers[j]), numbers[j] + "" + numbers[i]);
                String tmp2 = answer.replace(String.valueOf(numbers[j]), numbers[i] + "" + numbers[j]);
                System.out.println(tmp1 + " " + tmp2);
                m = String.valueOf(Math.max(Integer.parseInt(m), Math.max(Integer.parseInt(tmp1), Integer.parseInt(tmp2))));
            }
            answer = m;
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice p = new Practice();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int a = 123;

        System.out.println(p.solution(info, query));


    }
}
