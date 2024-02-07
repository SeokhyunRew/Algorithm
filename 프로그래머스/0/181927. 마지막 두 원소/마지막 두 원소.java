import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.copyOf(num_list, num_list.length+1);
        int lastnum = num_list[num_list.length-1];
        int before_lastnum = num_list[num_list.length-2];
        
        if (lastnum > before_lastnum){
            answer[answer.length-1] = lastnum-before_lastnum;
        } else{
            answer[answer.length-1] = lastnum * 2;
        }
        return answer;
    }
}