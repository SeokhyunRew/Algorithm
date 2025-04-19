class Solution {
    boolean solution(String s) {
        int left = 0;
        int right = 0;
        
        for(char c : s.toCharArray()){
            if(right>left) return false;
            if(c=='(') left++;
            else if(c==')') right++;
            else return false;
        }

        return left==right;
    }
}