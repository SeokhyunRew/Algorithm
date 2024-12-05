import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int index=0;
        
        while(index<arr.length){
            if(stack.empty()){
                stack.push(arr[index]);
                index++;
            }
            else if(stack.peek()<arr[index]){
                stack.push(arr[index]);
                index++;
            }
            else stack.pop();
        }
        
        int[] stk = new int[stack.size()];
        index = 0;
        while(!stack.empty()){
            stk[index] = stack.pop();
            index ++;
        }
        
        Arrays.sort(stk);
        
        return stk;
    }
}