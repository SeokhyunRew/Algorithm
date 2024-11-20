import java.util.*;
class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int[] temp = array.clone();
        
        Arrays.sort(temp);
        answer[0] = temp[temp.length-1];
        
        for(int i=0; i<array.length; i++){
            if(array[i]==temp[temp.length-1]) answer[1]=i; 
        }
        
        return answer;
    }
}