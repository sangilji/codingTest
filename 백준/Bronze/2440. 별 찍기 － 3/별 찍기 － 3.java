import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int INF = 1_000_000_000;
    static int MOD = 1_000_000_009;
    static int n;
    static int m;
    static int k;

    static int[] arr;
    static int sum;
    static int[] visit;
    static int[] price;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr1;
    static int count = 0;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static List<int[]>[] list;
    static List<int[]>[] list2;

    static int[] result;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for (int i = n; i > 0; i--) {
            sb.append("*".repeat(i)).append("\n");
        }
        System.out.println(sb);

    }

    private static void solution(String[] Directories, String[][] Commands) {
        Directory directory = new Directory("C:", null);
        for (int i = 0; i < Directories.length; i++) {
            String[] tmp = Directories[i].split("/");
            directory.add(tmp);
        }
        Directory current = directory;
        for (int i = 0; i < Commands.length; i++) {
            String[] tmp = Commands[i][1].split("/");
            if (Commands[i][0].equals("cd")) {
                current = current.cd(tmp, current);
            } else if (Commands[i][0].equals("mkdir")) {
                current.add2(tmp, current);
            } else {
                current.rmdir(tmp, current);
            }
        }

        current.parent();

    }

    static class Directory {
        @Override
        public String toString() {
            return "{" + folder +
                    '}';
        }

        String name;
        Directory parent;
        Map<String, Directory> folder = new HashMap<>();

        public Directory(String name, Directory parent) {
            this.name = name;
            this.parent = parent;
        }

        public void add(String[] tmp) {
            Directory pos = this;
            for (int i = 1; i < tmp.length; i++) {
                if (!pos.folder.containsKey(tmp[i])) {
                    pos.folder.put(tmp[i], new Directory(tmp[i], this));
                }
                pos = pos.folder.get(tmp[i]);
            }
        }

        public void add2(String[] tmp, Directory current) {
            if (tmp[0].equals("C:")) {
                Directory pos = this;
                for (int i = 1; i < tmp.length; i++) {
                    if (!pos.folder.containsKey(tmp[i])) {
                        pos.folder.put(tmp[i], new Directory(tmp[i], this));
                    }
                    pos = pos.folder.get(tmp[i]);
                }
            } else {
                Directory pos = current;
                for (int i = 0; i < tmp.length; i++) {
                    if (!pos.folder.containsKey(tmp[i])) {
                        pos.folder.put(tmp[i], new Directory(tmp[i], this));
                    }
                    pos = pos.folder.get(tmp[i]);
                }
            }
        }

        public Directory cd(String[] tmp, Directory current) {
            if (tmp[tmp.length - 1].contains(".")) {
                return current;
            }
            Directory pos;
            if (tmp[0].equals("C:")) {
                pos = this;
                for (int i = 1; i < tmp.length; i++) {
                    if (!pos.folder.containsKey(tmp[i])) {
                        return current;
                    }
                    pos = pos.folder.get(tmp[i]);
                }
            } else {
                pos = current;
                for (int i = 0; i < tmp.length; i++) {
                    if (!pos.folder.containsKey(tmp[i])) {
                        return current;
                    }
                    pos = pos.folder.get(tmp[i]);
                }
            }
            return pos;
        }

        public void rmdir(String[] tmp, Directory current) {
            Directory pos;
            if (tmp[0].equals("C:")) {
                pos = this;
                for (int i = 1; i < tmp.length - 1; i++) {
                    if (!pos.folder.containsKey(tmp[i])) {
                        return;
                    }
                    pos = pos.folder.get(tmp[i]);
                }
                pos.folder.remove(tmp[tmp.length - 1]);
            } else {
                pos = current;
                for (int i = 0; i < tmp.length - 1; i++) {
                    if (!pos.folder.containsKey(tmp[i])) {
                        return;
                    }
                    pos = pos.folder.get(tmp[i]);
                }
                pos.folder.remove(tmp[tmp.length - 1]);
            }
        }

        public void parent() {
            Directory pos = this;
            Stack<String> s = new Stack<>();
            while (true) {
//                System.out.println(pos.name);
                s.add(pos.name);
                if (pos.parent == null) {
                    break;
                }
                pos = pos.parent;
            }
            StringBuilder sb = new StringBuilder();
            while (!s.isEmpty()) {
                sb.append(s.pop()).append("/");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }


}