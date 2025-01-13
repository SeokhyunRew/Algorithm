class Solution {
    public int solution(int n) {
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            temp = n%3;
            n /= 3;
            sb.append(temp);
        }
        
        return Integer.parseInt(sb.toString(), 3);
    }
}