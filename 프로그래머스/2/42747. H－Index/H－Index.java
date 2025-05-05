class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        int over;
        
        for(int i=n; i>=0; i--){
            over=0;
            for(int j=0; j<n; j++) if(citations[j]>=i) over++;
            if(over>=i){
                answer=i;
                break;
            } 
        }
        
        return answer;
    }
}