import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        
        for(int num : arr){
            if(num%divisor==0) count++;
        }
        
        int[] answer = new int[count];
        count = 0;
        
        for(int num : arr){
            if(num%divisor==0){
                answer[count]=num;  
                count++;
            } 
        }
        
        Arrays.sort(answer);
        
        return (count!=0)?answer: new int[]{-1};
    }
}