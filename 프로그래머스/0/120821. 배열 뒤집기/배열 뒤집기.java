import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        
        for(int num : num_list){
            stack.push(num);
            temp ++;
        }
        
        int[] answer = new int[temp];
        
        for(int i=0; i<temp; i++ ){
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}