import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int temp = 0;
         
        for(String str : s.split(" ")){
            if(str.equals("Z")){
                answer -= temp;
                continue;
            }
            temp = Integer.parseInt(str);
            answer += temp;
        }
        
        return answer;
    }
}