class Solution {
    public int solution(String word) {            
        String charOrder = "AEIOU";
        int dictNum = 0;
        int[] num = {781, 156, 31, 6, 1};
        for (int i = 0; i < word.length(); i++) {
            dictNum += charOrder.indexOf(word.charAt(i)) * num[i] + 1;
        }
        return dictNum;
    }
}