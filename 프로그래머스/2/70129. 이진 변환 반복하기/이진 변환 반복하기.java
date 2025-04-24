class Solution {
    public int[] solution(String s) {
        int countZero = 0;
        int countIndex = 0;
        
        while(!s.equals("1")){
            int length = s.replaceAll("0", "").length();
            countZero += s.length()-length;
            s = toBinary(length);
            countIndex++;
        }
        
        return new int[] {countIndex, countZero};
    }
    
    private String toBinary(int len){
        StringBuilder sb = new StringBuilder();
        
        while(len!=0){
            sb.append(len%2);
            len = len/2;
        }
        
        return sb.reverse().toString();
        
    }
}