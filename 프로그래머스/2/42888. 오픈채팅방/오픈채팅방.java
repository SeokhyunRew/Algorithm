import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int index = 0;
        
        for(String str : record){
            String[] curr = str.split(" ");
            if(curr[0].equals("Enter") || curr[0].equals("Change")) map.put(curr[1], curr[2]);
            if(curr[0].equals("Enter") || curr[0].equals("Leave")) index++;
        }
        
        String[] answer = new String[index];
        index = 0;
        
        for(String str : record){
            String[] curr = str.split(" ");
            
            if(curr[0].equals("Enter")) answer[index]=map.get(curr[1])+"님이 들어왔습니다.";
            else if(curr[0].equals("Leave")) answer[index]=map.get(curr[1])+"님이 나갔습니다.";
            else continue;
            
            index++;
        }
        
        return answer;
    }
}