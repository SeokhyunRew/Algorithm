class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x_limit = (board[0]-1)/2;
        int y_limit = (board[1]-1)/2;
        int[] answer = {0,0};
        
        for(String str : keyinput){
            switch(str){
                case "left":
                    if(answer[0]-1 >= -x_limit) answer[0] -= 1;
                    break;
                case "right":
                    if(answer[0]+1 <= x_limit) answer[0] += 1;
                    break;
                case "down":
                    if(answer[1]-1 >= -y_limit) answer[1] -= 1;
                    break;
                case "up":
                    if(answer[1]+1 <= y_limit) answer[1] += 1;
                    break;
            }
        }
        
        return answer;
    }
}