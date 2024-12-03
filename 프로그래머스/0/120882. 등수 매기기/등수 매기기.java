import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[] temp = new int[score.length];
        int before = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<score.length; i++){
            temp[i] = score[i][0]+score[i][1];
        }
        
        Arrays.sort(temp);
        
        for(int i=1; i<=temp.length; i++){
            if(temp[temp.length-i] == before) continue;
            before = temp[temp.length-i];
            map.put(before, i);
        }
        
        for(int i=0; i<score.length; i++){
            answer[i] = map.get(score[i][0]+score[i][1]);
        }                 
                         
        return answer;
    }
}