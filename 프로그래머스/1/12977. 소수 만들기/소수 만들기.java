class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int temp = 0;
        
        boolean[] isPrime = new boolean[1000+999+998+1];
        
        for(int i=2; i<isPrime.length; i++){
            isPrime[i] = true;
        }
        
        for(int i=2; i<=Math.sqrt(2997); i++){
            if(isPrime[i]){
                for(int j=i*i; j<=2997; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(isPrime[nums[i]+nums[j]+nums[k]]){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}