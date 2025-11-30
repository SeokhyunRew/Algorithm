import java.util.*;
class Solution {
    public int[] solution(String myString) {
        List<Integer> temp = new ArrayList<>();
        int num = 0;
        
        for(char c : myString.toCharArray()){
            if(c=='x'){
                temp.add(num);
                num = 0;
            }
            else num++;
        }
        
        temp.add(num);
        
        int[] answer = new int[temp.size()];
        
        for(int i=0; i<temp.size(); i++) answer[i] = temp.get(i);
        
        return answer;
    }
}