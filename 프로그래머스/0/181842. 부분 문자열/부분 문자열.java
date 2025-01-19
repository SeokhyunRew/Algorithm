class Solution {
    public int solution(String str1, String str2) {
        String temp = str2;
        str2 = str2.replace(str1, "");
        
        if(temp.equals(str2)) return 0;
        else return 1;

    }
}