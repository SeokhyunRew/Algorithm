class Solution {
    public int[] solution(long n) {
        String temp = String.valueOf(n);
        int index = temp.length();
        int[] answer = new int[index];
        
        for(char ch : temp.toCharArray()){
            index--;
            answer[index] = ch - '0';
        }
        
        return answer;
    }
}