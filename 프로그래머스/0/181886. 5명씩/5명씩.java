class Solution {
    public String[] solution(String[] names) {
        int n = (names.length+4)/5;
        String[] answer = new String[n]; 
        
        for(int i=0; i<n; i++) answer[i] = names[5*i];
        
        return answer;
    }
}