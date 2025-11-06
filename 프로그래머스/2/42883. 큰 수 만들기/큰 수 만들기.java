class Solution {
    public String solution(String number, int k) {
        StringBuilder stack = new StringBuilder();
        int removeCount = k;
        
        for (char num : number.toCharArray()) {
            // 스택의 마지막 숫자가 현재 숫자보다 작으면 제거
            while (stack.length() > 0 && 
                   stack.charAt(stack.length() - 1) < num && 
                   removeCount > 0) {
                stack.deleteCharAt(stack.length() - 1);
                removeCount--;
            }
            stack.append(num);
        }
        
        // 아직 제거할 숫자가 남아있다면 뒤에서부터 제거
        if (removeCount > 0) {
            stack.setLength(stack.length() - removeCount);
        }
        
        return stack.toString();
    }
}