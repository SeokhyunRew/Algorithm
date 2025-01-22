class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int small_bill;
        int big_bill;
        int small_wallet;
        int big_wallet;
        
        while(true){
            small_bill = Math.min(bill[0], bill[1]);
            big_bill = Math.max(bill[0], bill[1]);
            small_wallet = Math.min(wallet[0], wallet[1]);
            big_wallet = Math.max(wallet[0], wallet[1]);
            
            if(small_bill<=small_wallet&&big_bill<=big_wallet) break;
            
            if(bill[0]>bill[1]) bill[0] /= 2;
            else bill[1] /= 2;
            
            answer++;
            
        }
            
        
        return answer;
    }
}