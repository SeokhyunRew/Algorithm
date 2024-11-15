class Solution {
    public String solution(String my_string) {
    
        char[] charArray = my_string.toCharArray();
        char[] answer = new char[charArray.length];
        
        for(int i=0; i<charArray.length; i++){
            
            answer[charArray.length - i -1] = charArray[i]; 
            
        }
        
        return new String(answer);
    }
}