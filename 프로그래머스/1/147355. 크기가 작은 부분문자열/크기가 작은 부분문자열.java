class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i=0; i<=t.length()-p.length(); i++){
            if(Long.valueOf(p)>=Long.valueOf(t.substring(i,i+p.length()))) answer++;
        }
        
        return answer;
    }
}