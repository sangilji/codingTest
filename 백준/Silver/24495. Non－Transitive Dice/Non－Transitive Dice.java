import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int INF = 1_000_000_000;
    static int n;
    static int m;
    static int k;
    static int str;
    static int[][] arr;
    static int[] tree;
    static int[] treeMaxIndex;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static long[] dp;
    static List<int[]>[] list;
    static List<int[]>[] list2;
    static int[] visit;
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] a = new int[4];
        int[] b = new int[4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < 4; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            int winA = 0;
            int A = 0;
            int winB = 0;
            int B = 0;
            for (int j = 0; j < 4; j++) {
                for (int l = 0; l < 4; l++) {
                    if (a[j] > b[l]) {
                        A++;
                    } else if (a[j] < b[l]) {
                        B++;
                    }
                }
            }
            boolean bool = false;
            for (int l = 1; l <= 10; l++) {
                for (int o = 1; o <= 10; o++) {
                    for (int p = 1; p <= 10; p++) {
                        for (int q = 1; q <= 10; q++) {
                            winB = 0;
                            int winBC = 0;
                            winA = 0;
                            int winAC = 0;
                            int[] c = {l, o, p, q};
                            for (int j = 0; j < 4; j++) {
                                for (int r = 0; r < 4; r++) {
                                    if (b[j] > c[r]) {
                                        winB++;
                                    } else if (b[j] < c[r]) {
                                        winBC++;
                                    }
                                    if (a[j] > c[r]) {
                                        winA++;
                                    } else if (a[j] < c[r]) {
                                        winAC++;
                                    }
                                }
                            }
                            if ((winB > winBC && winA < winAC && A > B) || (winA > winAC && winBC > winB && B > A)) {
                                bool = true;
                            }
                        }
                    }
                }
            }
            if (bool) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }

}