import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp;
        int num_before=0;
        
        Arrays.sort(numlist);
        
        for(int i=0; i<numlist.length; i++){
            answer[i] = Math.abs(numlist[i]-n);
            map.put(answer[i], numlist[i]);
        }
        
        Arrays.sort(answer);
        
        for(int i=0; i<numlist.length; i++){
            temp = answer[i];    
            if(num_before==answer[i]){
                answer[i] = n-answer[i];
            }else{
                answer[i] = map.get(answer[i]);
            }
            num_before=temp;
        }
        
        return answer;
    }
}