class Solution {
    public long solution(long n) {
        long temp = (long) Math.sqrt(n);
        return ((long) Math.pow(temp,2)==n)?(long) Math.pow(temp+1,2):-1 ;
    }
}