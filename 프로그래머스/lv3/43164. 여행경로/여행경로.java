import java.util.*;

class Solution {
    
    Boolean[] bool;
    StringBuilder sb;
    String result= "J";
    public String[] solution(String[][] tickets) {
        bool = new Boolean[tickets.length];
        Arrays.fill(bool,false);
        sb = new StringBuilder();
        sb.append("ICN ");
        dfs(tickets,"ICN",0);
        String[] s = result.split(" ");
        return s;
    }
    
    public void dfs(String[][] tickets, String str, int depth){
        
        if(depth == tickets.length){
            if(result.compareTo(sb.toString())>0)
                result=sb.toString();
            return;
        }
        
        for(int i =0; i<tickets.length;i++){
            if(!bool[i] && str.equals(tickets[i][0])){
                bool[i]=true;
                sb.append(tickets[i][1]).append(" ");
                dfs(tickets,tickets[i][1],depth+1);
                bool[i]=false;
                sb.delete(sb.length()-4,sb.length());
            }
        }
    }
}