class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int temp = 0;
        
        for(int i=1; i<=number; i++){
            for(int j=1; j<= Math.sqrt(i); j++){
                if(i%j==0){
                    if(j==Math.sqrt(i)) temp++;
                    else temp += 2;
                }
            }
            if(temp>limit) temp = power;
            answer += temp;
            temp = 0;
        }
        
        return answer;
    }
}