class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int indexOne = 0;
        int indexTwo = 0;
        
        for(int i=0; i<goal.length; i++){
            if(indexOne < cards1.length && cards1[indexOne].equals(goal[i])) indexOne++;
            else if(indexTwo < cards2.length && cards2[indexTwo].equals(goal[i])) indexTwo++;
            else return "No";
        }
        
        return answer;
    }
}