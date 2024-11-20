import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int temp = 0;
        String[] array = my_string.split(" ");
        
        for(int i=0 ; i< array.length; i++){
            if(array[i].equals("-")){
                answer -= Integer.parseInt(array[i+1])*2;
                continue;
            }else if(array[i].equals("+")){
                continue;
            }
            answer += Integer.parseInt(array[i]);
        }
        
        return answer;
    }
}