class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        
        for(char ch : my_string.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                continue;
            }
            answer.append(ch);
        }
        
        return answer.toString();
    }
}