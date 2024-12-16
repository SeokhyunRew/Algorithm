class Solution {
    public long solution(int a, int b) {
        int small = Math.min(a,b);
        int big = Math.max(a,b);
        
        return (long) (small+big)*(big-small+1)/2;
    }
}