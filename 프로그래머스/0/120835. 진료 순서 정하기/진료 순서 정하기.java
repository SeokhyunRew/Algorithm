import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int temp;
        
        for(int i=0; i<emergency.length; i++){
            temp = 1;
            for(int j=0; j<emergency.length; j++){
                if(emergency[i]<emergency[j]){
                    temp ++;
                }
            }
            answer[i] = temp;
        }
        
        return answer;
    }
}