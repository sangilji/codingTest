import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Character>> nodes = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            nodes.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            nodes.get(parent - 'A' + 1).add(left);
            nodes.get(parent - 'A' + 1).add(right);
        }

        print(1);
        sb.append("\n");
        System.out.println();
        print2(1);
        System.out.println();
        sb.append("\n");
        print3(1);

    }

    private static void print(int current) {
        System.out.print((char) (current - 1 + 'A'));
        if (nodes.get(current).get(0) != '.') {
            print(nodes.get(current).get(0) - 'A' + 1);
        }
        if (nodes.get(current).get(1) != '.') {
            print(nodes.get(current).get(1) - 'A' + 1);
        }
    }

    private static void print2(int current) {

        if (nodes.get(current).get(0) != '.') {
            print2(nodes.get(current).get(0) - 'A' + 1);
        }
        System.out.print((char) (current - 1 + 'A'));

        if (nodes.get(current).get(1) != '.') {
            print2(nodes.get(current).get(1) - 'A' + 1);
        }
    }

    private static void print3(int current) {

        if (nodes.get(current).get(0) != '.') {
            print3(nodes.get(current).get(0) - 'A' + 1);
        }
        if (nodes.get(current).get(1) != '.') {
            print3(nodes.get(current).get(1) - 'A' + 1);
        }
        System.out.print((char) (current - 1 + 'A'));
    }

}
