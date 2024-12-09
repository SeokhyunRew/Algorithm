class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        
        for(String str : my_strings){
            sb.append(str.substring(parts[index][0], parts[index][1]+1));
            index ++;
        }
        
        return sb.toString();
    }
}