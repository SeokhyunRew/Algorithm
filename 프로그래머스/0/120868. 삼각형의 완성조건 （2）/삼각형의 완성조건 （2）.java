class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int long_side = Math.max(sides[0], sides[1]); 
        int short_side = Math.min(sides[0], sides[1]);
      
        if(long_side-short_side > 1) answer += long_side - (long_side-short_side) - 1;
        if(long_side==short_side) answer += long_side-1;
        answer += (long_side+short_side) - long_side;
        
        return answer;
    }
}