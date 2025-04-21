class Solution {
    public int[] solution(int[] prices) {
        int priceLength = prices.length;
        int[] answer = new int[priceLength];
        
        for(int i=0; i<priceLength; i++){
            int curr = prices[i];
            for(int j=i+1; j<priceLength; j++){
                int next = prices[j];
                if(curr>next){
                    answer[i]=j-i;
                    break;
                }
                if(j==priceLength-1) answer[i]=priceLength-i-1;
            }
        }
        
        return answer;
    }
}