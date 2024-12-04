class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while((int) chicken/10 != 0){
            answer += (int) chicken/10;
            chicken = chicken%10 + (int) chicken/10;
        }
        return answer;
    }
}