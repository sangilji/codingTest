import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.List;
    import java.util.StringTokenizer;

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
    // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public class Main {

        static int n;
        static int m;
        static int k;
        static int[] arr;
        static int[] a;
        static int[] b;
        static int[] visit;
        static int[] dp;
        static int[] dx = {1, 0, -1, 0};
        static int[] dy = {0, 1, 0, -1};
        static List<Integer>[] list;
        static StringBuilder sb = new StringBuilder();
        static int count;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            String[] tmp = br.readLine().split("");
            int a = 0;
            int b = 0;
            int result = 0;
            int wCount = 0;
            int bCount = 0;

            while (a <= b && b < n) {
                if (bCount <= m) {
                        if (tmp[b].equals("W")) {
                            wCount++;
                        } else {
                            bCount++;
                        }
                    b++;
                } else {
                    if (tmp[a].equals("W")) {
                        wCount--;
                    } else {
                        bCount--;
                    }
                    a++;
                }
                if (bCount<=m && wCount >= k) {
                    result = Math.max(result, b - a);
//                    System.out.println(a + ":" + b);
                }
//                System.out.println(bCount + ":" + wCount);
//                System.out.println();
            }
            System.out.println(result);
        }


    }