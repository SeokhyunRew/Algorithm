class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long maxTime = findMaxTime(times);
        long low = 1;
        long high = maxTime*n;
        
        while(low<=high){
            long mid = low+(high-low)/2;
            long count = 0;
            
            for(int i=0; i<times.length; i++){
                count += mid/times[i];
                if(count>=n) break;
            }
            
            if(count>=n){
                answer = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        
        return answer;
    }
    
    private long findMaxTime(int[] times){
        long maxTime = 0;
        for(int num : times) maxTime = (num>maxTime)?num:maxTime;
        
        return maxTime; 
    }
}