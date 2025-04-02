import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int target_move;
        int index;
        int doll;
        Stack<Integer> basket = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            target_move = moves[i]-1;
            index=0;
            while(index<board.length){
                doll = board[index][target_move];
                if(doll==0) index++;
                else{
                    board[index][target_move] = 0;
                    if(!basket.empty()){
                        if(basket.peek()==doll){
                            basket.pop();
                            answer += 2;
                        }else basket.push(doll);
                    }else basket.push(doll);
                    break;
                }
            }
        }
        
        return answer;
    }
}