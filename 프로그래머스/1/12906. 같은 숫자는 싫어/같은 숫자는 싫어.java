import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int temp = -1;
        int count = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=temp) count ++;
            temp = arr[i];
        }
        
        int[] answer = new int[count];
        temp = -1;
        count = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=temp){
                answer[count]=arr[i];
                count++;
            }
            temp = arr[i];
        }
        
        return answer;
    }
}