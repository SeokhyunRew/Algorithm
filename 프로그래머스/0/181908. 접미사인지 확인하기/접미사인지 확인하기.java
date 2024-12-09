class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        String[] array = new String[my_string.length()];
        
        for(int i=0; i<my_string.length(); i++){
            array[i] = my_string.substring(my_string.length()-i-1, my_string.length());
        }
        
        for(int i=0; i<array.length; i++){
            if(array[i].equals(is_suffix)) answer = 1;
        }
        
        return answer;
    }
}