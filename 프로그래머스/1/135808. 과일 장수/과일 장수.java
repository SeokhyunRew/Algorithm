import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        if(score.length<m) return answer;
        
        Arrays.sort(score);
        
        for(int i=score.length/m; i>0; i--){
            answer += score[score.length-(i*m)]*m;
        }
        
        return answer;
    }
}