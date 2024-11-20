class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        
        for(char c : my_string.toCharArray()){
            if(index==num1){
                answer.append(my_string.charAt(num2));
            }else if(index==num2){
                answer.append(my_string.charAt(num1));
            }else{
                answer.append(c);    
            }
            index ++;
        }
        
        return answer.toString();
    }
}