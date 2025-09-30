import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int N = order.length;
        int curr=1;
        int index=0;
        Stack<Integer> stack = new Stack<>();
        
        while(curr<=N+1){
            if(index<N&&curr==order[index]){
                answer++;
                index++;
                curr++;
            }else if(!stack.isEmpty()&&order[index]==stack.peek()){
                answer++;
                index++;
                stack.pop();
            }else{
                stack.push(curr);
                curr++;
            }
        }
        
        return answer;
    }
}
