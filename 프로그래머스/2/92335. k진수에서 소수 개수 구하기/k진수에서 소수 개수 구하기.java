class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        for(String str : numToK(n,k).split("0")){
            if(str.length()==0) continue;
            if(isPrime(Long.valueOf(str))) answer++;    
        }
        
        return answer;
    }
    
    private String numToK(int n, int k){
        StringBuilder sb = new StringBuilder();
        
        while(n!=0){
            sb.insert(0, n%k);
            n /= k;
        }
        
        return sb.toString();
    }
    
    private boolean isPrime(Long num){
        if(num==1) return false;
        
        for(int i=2; i<= (int) Math.sqrt(num); i++) if(num%i==0) if(num%i==0) return false; 
        
        return true;
    }
    
}