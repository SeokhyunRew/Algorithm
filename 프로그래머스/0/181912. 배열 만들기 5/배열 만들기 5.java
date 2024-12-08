class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int count = 0;
        
        for(String str : intStrs){
            if(Integer.parseInt(str.substring(s,s+l))>k) count++;
        }
        
        int[] answer = new int[count];
        count = 0;
        
        for(String str : intStrs){
            if(Integer.parseInt(str.substring(s,s+l))>k){
                answer[count] = Integer.parseInt(str.substring(s,s+l));
                count++;
            }
        }
        
        return answer;
    }
}