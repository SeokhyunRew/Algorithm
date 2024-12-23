class Solution {
    public boolean solution(int x) {
        int temp = 0;
        
        for(char ch : String.valueOf(x).toCharArray()){
            temp += ch - '0';
        }
        
        return x%temp==0;
    }
}