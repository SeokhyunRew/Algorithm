class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int keep = 0;
        int temp = 0;
        
        while(true){
            if(n==0&&(keep==0||keep<a)) break;
            
            temp = keep;
            keep = (keep+n)%a;
            n = (temp+n)/a*b;
            
            answer+=n;
        }
        
        
        return answer;
    }
}