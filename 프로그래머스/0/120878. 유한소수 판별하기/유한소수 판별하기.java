class Solution {
    public int solution(int a, int b) {
        int gcd = gcd(a, b);
        b /= gcd;
        
        while(b%2==0 || b%5==0){
            if(b%2==0) b/=2;
            else if(b%5==0) b/=5;
        }
        
        return (b==1)?1:2;
    }
    
    // 유클리드 호제법으로 GCD 계산
    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}