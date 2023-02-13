import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int n;
    static int m;
    static int[][] map;
    static List<CCTV> cctvList;
    static int[][] copyMap;
    static int[] dx = {0,1 , 0, -1};
    static int[] dy = {1,0 , -1, 0};
    static int min =Integer.MAX_VALUE;

    static class CCTV{
        int x;
        int y;
        int number;
        int pos;

        public CCTV(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copyMap = new int[n][];
        cctvList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]>=1 && map[i][j]<=5){
                    cctvList.add(new CCTV(i,j,map[i][j]));
                }
            }
        }
        dfs(0);
        System.out.println(min);
    }

    private static void dfs(int depth) {
        if (depth == cctvList.size()){
            for (int i = 0; i < n; i++) {
                copyMap[i] = Arrays.copyOf(map[i],m);
            }
            makeCCTV();
            findMin();
            return;
        }

        for (int i = 0; i < 4; i++) {
            cctvList.get(depth).pos = i;
            dfs(depth+1);
        }
    }

    private static void findMin() {
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j]==0){
                    tmp++;
                }
            }
        }
        min = Math.min(tmp, min);
    }

    private static void makeCCTV() {
        for (CCTV cctv: cctvList) {
            int x =cctv.x;
            int y =cctv.y;
            int number = cctv.number;
            int pos = cctv.pos;

            if (number == 1){
                makePos(x,y,pos);
            } else if (number == 2){
                if (pos == 0 || pos ==2){
                    makePos(x,y,0);
                    makePos(x,y,2);
                } else {
                    makePos(x,y,1);
                    makePos(x,y,3);
                }
            } else if (number == 3){
                makePos(x,y,pos);
                makePos(x,y,(pos+1)%4);
            } else if (number == 4){
                makePos(x,y,pos);
                makePos(x,y,(pos+1)%4);
                makePos(x,y,(pos+2)%4);
            } else {
                makePos(x,y,0);
                makePos(x,y,1);
                makePos(x,y,2);
                makePos(x,y,3);
            }
        }
    }

    private static void makePos(int x, int y, int pos) {

        while (true){
            x+= dx[pos];
            y+= dy[pos];
            if (x<0||y<0||x>=n||y>=m|| copyMap[x][y]==6){
                break;
            }
            if (copyMap[x][y]==0){
                copyMap[x][y]=7;
            }
        }
    }
}