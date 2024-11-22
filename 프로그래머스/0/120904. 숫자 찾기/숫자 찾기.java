class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        String str = String.valueOf(num);
        char[] array = str.toCharArray();
        
        for(int i=0; i<array.length; i++){
            if(k == array[i] - '0'){
                return i+1;
            }
        }
        
        return answer;
    }
}