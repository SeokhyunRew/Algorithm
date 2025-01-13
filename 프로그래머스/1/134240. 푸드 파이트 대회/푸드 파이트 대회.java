class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(int i=1; i<food.length; i++){
            for(int j=0; j<food[i]/2; j++){
                temp.append(i);
            }
        }
        
        answer.append(temp);
        answer.append(0);
        answer.append(temp.reverse());
        
        return answer.toString();
    }
}