import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> array = new ArrayList<>();
        
        for(int num : numlist){
            if(num%n==0) array.add(num);
        }
        
        int[] answer = new int[array.size()];
        
        for(int i=0; i<array.size(); i++){
            answer[i] = array.get(i);
        }
        
        return answer;
    }
}