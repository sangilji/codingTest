import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
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
            answer.append("R");
        } else {
            answer.append("T");
        }
        if(map.get("C")>=map.get("F")){
            answer.append("C");
        } else {
            answer.append("F");
        }
        if(map.get("J")>=map.get("M")){
            answer.append("J");
        } else {
            answer.append("M");
        }
        if(map.get("A")>=map.get("N")){
            answer.append("A");
        } else {
            answer.append("N");
        }
        
        return answer.toString();
    }
}