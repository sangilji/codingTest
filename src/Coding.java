import java.util.*;

public class Coding {
    public int solution(int[][] maps) {
        int right = maps[0].length-1;
        int bottom = maps.length-1;
        int top = 0;
        int left = 0;
        int count = 0;
        boolean move;

        Stack<int[]> s = new Stack<>(); //지난 길 기억하기
        int lastX=0,lastY=0;
        int x=0,y=0; //현재위치
        while(true){
            System.out.println(x+","+y);
            move=false;
            s.push(new int[]{x,y});
            if(x==bottom && y==right){
                break;
            }
            if(x<bottom && maps[x+1][y]==1 && !(x+1==lastX &&y==lastY)){   //하
                x++;
                move=true;
            }
            else if(y<right && maps[x][y+1]==1 && !(x==lastX &&y+1==lastY)){// 우
                y++;
                move=true;
            }
            else if(x>top && maps[x-1][y]==1 && !(s.peek()[0]==x-1 && s.peek()[1]==y) && !(x-1==lastX &&y==lastY)){// 상
                x--;
                move=true;
            }
            else if(y>left && maps[x][y-1]==1 && !(s.peek()[0]==x && s.peek()[1]==y-1) && !(x==lastX &&y-1==lastY)){// 좌
                y--;
                move=true;
            }
            lastX=s.peek()[0];
            lastY=s.peek()[1];
            if(!move){
                s.pop();

                if(s.isEmpty())
                    count++;
                else{
                    x=s.peek()[0];
                    y=s.peek()[1];
                }
            }
            if(x==0 && y==0)
                return -1;
        }
s.removeAll(s.stream().toList());



        return s.size();
    }
    public static void main(String[] args) {
        Coding c = new Coding();
       int maps[][] ={{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(c.solution(maps));

    }
}
