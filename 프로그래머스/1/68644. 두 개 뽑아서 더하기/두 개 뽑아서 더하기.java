import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        
        int[] answer = new int[set.size()];
        int temp = 0;
        
        for(Integer num : set){
            answer[temp] = num;
            temp ++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}