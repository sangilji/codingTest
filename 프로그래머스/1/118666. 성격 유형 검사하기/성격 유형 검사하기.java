import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String,Integer> map = new HashMap<>();
        map.put("R",0);map.put("T",0);map.put("C",0);map.put("F",0);
        map.put("J",0);map.put("M",0);map.put("A",0);map.put("N",0);
        for(int i =0;i<survey.length;i++){
            int point = Math.abs(choices[i]-4);
            if(choices[i]>4){
                map.put(survey[i].substring(1,2),map.get(survey[i].substring(1,2))+point);
            } else if(choices[i]<4){
                map.put(survey[i].substring(0,1),map.get(survey[i].substring(0,1))+point);
            }
        }
        if(map.get("R")>=map.get("T")){
            answer+="R";
        } else {
            answer+="T";
        }
        if(map.get("C")>=map.get("F")){
            answer+="C";
        } else {
            answer+="F";
        }
        if(map.get("J")>=map.get("M")){
            answer+="J";
        } else {
            answer+="M";
        }
        if(map.get("A")>=map.get("N")){
            answer+="A";
        } else {
            answer+="N";
        }
        
        return answer;
    }
}