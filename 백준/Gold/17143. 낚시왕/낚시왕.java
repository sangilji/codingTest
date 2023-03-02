import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int m;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};

    static class Shark {
        int x;
        int y;
        int speed;
        int direction;
        int z;

        public Shark(int x, int y, int speed, int direction, int z) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.direction = direction;
            this.z = z;
        }
    }

    static List<Shark> sharks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(x, y, s, d, z));
        }
        start();
    }

    private static void start() {
        int fisherY = 0;
        int score = 0;
        while (fisherY <= c) {
            fisherY++;
            Shark fishShark = null;
            for (Shark s : sharks) {
                if (s.y == fisherY) {
                    if (fishShark == null) {
                        fishShark = s;
                    } else if (fishShark.x > s.x) {
                        fishShark = s;
                    }
                }
            }
            if (fishShark != null) {
                score += fishShark.z;
                sharks.remove(fishShark);
            }
            move();
        }

        System.out.println(score);
    }

    private static void move() {
        List<Shark> deleteList = new ArrayList<>();
        Shark[][] map = new Shark[r + 1][c + 1];
        for (Shark s : sharks) {
            if (s.direction <= 2) {
                int tmp = s.speed % (r*2 - 2);
                s.x += dx[s.direction] * tmp;

                if (s.x < 1) {
                    s.x = 1 + (1 - s.x);
                    s.direction = 2;
                } else if (s.x > r) {
                    s.x = r - (s.x - r);
                    s.direction = 1;
                }

                if (s.x < 1) {
                    s.x = 1 + (1 - s.x);
                    s.direction = 2;
                } else if (s.x > r) {
                    s.x = r - (s.x - r);
                    s.direction = 1;
                }

            } else {
                int tmp = s.speed % (c*2 - 2);
                s.y += dy[s.direction] * tmp;

                if (s.y < 1) {
                    s.y = 1 + (1 - s.y);
                    s.direction=3;
                } else if (s.y > c) {
                    s.y = c - (s.y - c);
                    s.direction=4;
                }

                if (s.y < 1) {
                    s.y = 1 + (1 - s.y);
                    s.direction=3;
                } else if (s.y > c) {
                    s.y = c - (s.y - c);
                    s.direction= 4;
                }

            }
            if (map[s.x][s.y] == null) {
                map[s.x][s.y] = s;

            } else if (map[s.x][s.y].z < s.z) {
                deleteList.add(map[s.x][s.y]);
                map[s.x][s.y] = s;
            } else {
                deleteList.add(s);
            }
        }
        sharks.removeAll(deleteList);
    }
}