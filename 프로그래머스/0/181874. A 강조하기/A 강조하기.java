class Solution {
    public String solution(String myString) {
        myString = myString.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for(char c : myString.toCharArray()){
            if (c=='a') c='A';
            sb.append(c);
        }
       
        return sb.toString();
    }
}