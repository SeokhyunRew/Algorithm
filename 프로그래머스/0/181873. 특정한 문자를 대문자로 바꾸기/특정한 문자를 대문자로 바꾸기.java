class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        char a = alp.charAt(0);
        
        for(char c : my_string.toCharArray()){
            if(c==a) c=Character.toUpperCase(c);
            sb.append(c);
        }
        
        return sb.toString();
    }
}