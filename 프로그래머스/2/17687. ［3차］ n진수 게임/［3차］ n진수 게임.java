class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int temp=0;
        
        while(sb.length()<t*m){
            sb.append(MakeToN(temp,n));
            temp++;
        }
        
        String ansStr = sb.toString();
        
        for(int i=0; i<t; i++) ans.append(ansStr.charAt(p+m*i-1));
        
        return ans.toString();
    }
    
    private String MakeToN(int ten, int n){
        StringBuilder sb = new StringBuilder();
        
        if(ten==0) return "0";
        
        while(ten!=0){
            if(ten%n>=10){
                sb.insert(0, (char) ('A'+(ten%n-10)));
            }else{
                sb.insert(0, ten%n);
            }
            ten /= n;
        }
        
        return sb.toString();
    }
    
}