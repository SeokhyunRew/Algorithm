import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Integer[] sortArray = new Integer[emergency.length];
        
        for(int i=0; i<emergency.length; i++){
            sortArray[i] = emergency[i];
        }
        
        Arrays.sort(sortArray, Collections.reverseOrder());
        
        for(int i=0; i<emergency.length; i++){
            for(int j=0; j<emergency.length; j++){
                if(emergency[i]==sortArray[j]){
                    answer[i] = j+1;
                }
            }
        }
        
        return answer;
    }
}