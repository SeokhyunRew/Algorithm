import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> array = new ArrayList<>();
        
        for(int i=1; i*i<= n; i++){
            if(n%i==0){
                array.add(i);
                if(i != n/i){
                    array.add(n/i);  
                }
            }
        }
        
        Collections.sort(array);
        int[] answer = new int[array.size()];
        
        for(int i=0; i<array.size(); i++){
            answer[i] = array.get(i);
        }
        
        return answer;
    }
}