package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1043 {
    static int[] known;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int truthCount = s.nextInt();
        known = new int[n + 1];
        for (int i = 0; i < truthCount; i++) {
            int tmp = s.nextInt();
            known[tmp] = 1;
        }
        int[][] party = new int[n + 1][m + 1];
        int[][] partyMember = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int tmp = s.nextInt();
            for (int j = 0; j < tmp; j++) {
                int person = s.nextInt();
                party[person][i] = 1;
                partyMember[i][j] = person;

            }
        }
        bfs(party);
        int result = 0;
        for (int i = 1; i < m + 1; i++) {
            result += checkParty(i, partyMember);
        }
        System.out.println(result);

    }

    private static int checkParty(int i, int[][] partyMember) {
        for (int j = 0; j < partyMember.length; j++) {
            if (partyMember[i][j] == 0) {
                break;
            }
            if (known[partyMember[i][j]] == 1) {
                return 0;
            }
        }
        return 1;
    }

    private static void bfs(int[][] party) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[party[0].length];
        for (int i = 1; i < party.length; i++) {
            if (known[i] == 1) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i = 1; i < party[0].length; i++) {
                if (party[tmp][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    for (int j = 1; j < party.length; j++) {
                        if (party[j][i] == 1 && known[j] != 1) {
                            known[j] = 1;
                            q.add(j);
                        }
                    }
                }
            }

        }
    }
}
