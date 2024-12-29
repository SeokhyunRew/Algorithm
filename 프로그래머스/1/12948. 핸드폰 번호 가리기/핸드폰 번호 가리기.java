class Solution {
    public String solution(String phone_number) {
        
        int temp = phone_number.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<temp-4; i++){
            sb.append("*");
        }
        
        sb.append(phone_number.substring(temp-4));
        return sb.toString( );
    }
}