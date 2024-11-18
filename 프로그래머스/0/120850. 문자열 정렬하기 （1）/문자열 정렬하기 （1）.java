import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        StringBuilder sb = new StringBuilder();
   
        for(char ch : my_string.toCharArray()){
            if(ch>='0' && ch<='9'){
                sb.append(ch);
            }
        }
        
        String str = sb.toString();
        int[] answer = new int[sb.length()];
        int temp = 0;
        
        for (char ch : str.toCharArray()) {
            answer[temp] = ch - '0';
            temp++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}